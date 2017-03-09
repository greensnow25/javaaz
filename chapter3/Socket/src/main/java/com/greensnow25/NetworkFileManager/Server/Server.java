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


import com.greensnow25.NetworkFileManager.LIbrery.Classes.GoOverParent;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int port = 8189;
    Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    private void starServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        this.socket = serverSocket.accept();
        this.runAplication();
    }

    public void runAplication() throws IOException {
        try (InputStream fromClient = this.socket.getInputStream();
             OutputStream toClient = this.socket.getOutputStream();
             BufferedInputStream bis = new BufferedInputStream(fromClient);
             BufferedOutputStream bos = new BufferedOutputStream(toClient);
                PrintWriter pw = new PrintWriter(System.out)) {
                StringBuilder sb = new StringBuilder();
            String line = null;
            do {

                int len;
                byte[] buffer = new byte[2048];

                while((len = bis.read())>0){
                char ch = (char)len;
                    sb.append(ch);
                    line = sb.toString();
                    sb.delete(0,line.length());
                }


                if(line.equals("wiev")){

                }else if(line.equals("up")){
                    GoOverParent up = new GoOverParent();

                }else if(line.equals("down")){

                }else if(line.equals("download")){

                }else if(line.equals("upload")){

                }


            } while (!line.equals("quit"));

        }
    }
}
