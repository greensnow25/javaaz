package com.greensnow25.NetworkFileManager.Server;
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


import com.greensnow25.NetworkFileManager.LIbrery.Classes.DownlodFile;
import com.greensnow25.NetworkFileManager.LIbrery.Classes.GoOverParent;
import com.greensnow25.NetworkFileManager.LIbrery.Classes.UploadFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.String.valueOf;

public class Server {
    public static void main(String[] args) throws IOException {

        Server server = new Server("D:\\");
        server.starServer();
        server.runAplication();

    }

    private final int port = 2000;
    private Socket socket;


    private File fileChild;
    private String path;
    private File file;

    public Server(String filePath) {
        //    this.socket = socket;
        this.path = filePath;
    }

    private void starServer() throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("conection wait...");
            this.socket = serverSocket.accept();
            System.out.println("conection sucses.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void runAplication() throws IOException {

        this.file = new File(this.path);
        InputStream fromClient = this.socket.getInputStream();
        OutputStream toClient = this.socket.getOutputStream();
        try (DataInputStream dataIn = new DataInputStream(fromClient);
             DataOutputStream dataOut = new DataOutputStream(toClient);
             PrintWriter pw = new PrintWriter(System.out, true);
             ObjectOutputStream oos = new ObjectOutputStream(toClient);
            BufferedInputStream downF = new BufferedInputStream(fromClient)) {

            String line;
            String answerParent;
            String answerChild;
            String doSmth;

            do {
                dataOut.writeUTF("What do you like to do?");


                line = dataIn.readUTF();


                if (line.equals("wiev")) {
                    String[] list = new String[file.listFiles().length];
                    int pos = 0;

                    for (File files : file.listFiles()) {
                       list[pos++] = files.getAbsolutePath();
                    }

                    oos.writeObject((String[])list);

                } else if (line.equals("up")) {
                    dataOut.writeUTF("Enter parent directory.");

                    answerChild = dataIn.readUTF();

                    this.fileChild = new File(answerChild);
                    GoOverParent up = new GoOverParent(file, fileChild);
                    this.file = up.goOver();
                    System.out.println(file.getAbsolutePath());
                } else if (line.equals("down")) {
                    dataOut.writeUTF("Enter parent directory.");

                    answerChild = dataIn.readUTF();


                } else if (line.equals("download")) {
                    dataOut.writeUTF("write full path to file what you would like download");
                    line = dataIn.readUTF();  // принимаем название файла, которое хочет загрузить клиент
                   File downFile = new File(line);
                     long lenght=downFile.length();
                    dataOut.writeLong(lenght);  // отпавляем клиенту длинну файла
                    if(downFile.isDirectory()){
                        dataOut.writeUTF("sory, but you want to download a directory");
                    }else{
                        dataOut.writeUTF("file exist. start download");
                       FileInputStream qqq = new FileInputStream(line);
                        int len;
                        byte[] buffer = new byte[1024];
                        dataIn.readUTF();
                        toClient.flush();
                        while((len = qqq.read(buffer))!= -1){
                            dataOut.write(buffer,0,len);
                        }
                        dataOut.writeUTF("Sucsesful");



                    }

                } else if (line.equals("upload")) {

                }


            } while (!line.equals("quit"));

        }
    }
}
