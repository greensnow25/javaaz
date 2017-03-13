package com.greensnow25.NetworkFileManager.Client;

import com.greensnow25.NetworkFileManager.LIbrery.Classes.DownlodFile;
import com.sun.corba.se.pept.encoding.InputObject;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Перед реализацией в коде. Составить каркас приложения на интерфейсах. С описанием.
 * 1. Разработать клиент серверное приложение на сокетах.
 * 2. Серверная часть должна реализовывать следующее апи
 * - получить список корневого каталога. Корневой каталог задается при запуске сервера.
 * - перейти в подкаталог.
 * - спуститься в родительский каталог
 * - скачать файл
 * - загрузить файл.
 * 3. Клиент должен это апи уметь вызывать.
 * <p>
 * 4. настройки портов и адреса считывать с app.properties
 */

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Client client = new Client();
        client.conectServer();
        client.runClient();
    }

    private final String host = "127.0.0.1";
    private final int port = 2000;
    Socket socket;

    public void conectServer() throws IOException {
        InetAddress inetAddress = InetAddress.getByName(host);
        this.socket = new Socket(inetAddress, port);
    }

    public void runClient() throws IOException, ClassNotFoundException {

        try (InputStream fromServer = this.socket.getInputStream();
             OutputStream toServer = this.socket.getOutputStream();
             DataInputStream dataIn = new DataInputStream(fromServer);
             DataOutputStream dataOut = new DataOutputStream(toServer);
             DataOutputStream dataOutConsol = new DataOutputStream(System.out);
             BufferedReader enterKeyboard = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter(System.out, true);
             ObjectInputStream ois = new ObjectInputStream(fromServer)) {
            String line;
            String answer;
            do {

                line = dataIn.readUTF();
                pw.println(line);
                answer = enterKeyboard.readLine();
                dataOut.writeUTF(answer);
                if (answer.equals("wiev")) {

                    String[] fileList = (String[]) ois.readObject();

                    for (int i = 0; i != fileList.length; i++) {
                        pw.println(fileList[i]);
                    }


                } else if (answer.equals("download")) {
                    pw.println(dataIn.readUTF());
                    answer = enterKeyboard.readLine(); //вводим файл который хотим скачать
                    dataOut.writeUTF(answer);        // отправляем название файла, который хотим загрузить

                    long lengFile = dataIn.readLong();
                    File tmpDown = new File("D:\\javaTemp\\1.txt");
                    FileOutputStream downfi = new FileOutputStream(tmpDown);
                    int len;
                    int count = 0;
                    byte[] buffer = new byte[1024];

                    while ((len = dataIn.read(buffer)) != -1) {
                        if (count == 1) {
                            downfi.write(buffer, 0, len);

                        }
                        dataOut.writeUTF("OK");
                        count = 1;
                        if (len == (int) lengFile) {
                            break;
                        }
                    }
                    pw.println(dataIn.readUTF());

                }else if(answer.equals("upload")){

                }
                else {
                    dataOut.writeUTF(answer);
                }

            } while (!line.equals("quit"));

        }
    }


}
//    int len;
//    byte[] buffer = new byte[1024];
//                while ((len = dataIn.read(buffer))!=-1){
//                        dataOutConsol.write(buffer,0,len);
//                        }