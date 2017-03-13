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


import com.greensnow25.NetworkFileManager.LIbrery.Classes.BaseAction;

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
    private String root;
    private File file;

    public Server(String filePath) {

        this.root = filePath;
    }

    private void starServer() throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("conection wait...");
            this.socket = serverSocket.accept();
            System.out.println("conection sucses.");
            this.runAplication();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void runAplication() throws IOException {

        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(),true)){
            BaseAction baseAction = new BaseAction(socket.getInputStream(), socket.getOutputStream(),root );
            String line;
          do{
              line = in.readLine();
              System.out.println(line);
          }while (!line.equals("stop"));

        }
    }
}
