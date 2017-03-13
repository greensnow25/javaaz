package com.greensnow25.NetworkFileManager.Client;

import com.greensnow25.NetworkFileManager.LIbrery.Classes.BaseAction;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

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

    }

    private final String host = "127.0.0.1";
    private final int port = 2000;
    Socket socket;


    public void conectServer() throws IOException {
        InetAddress inetAddress = InetAddress.getByName(host);
        this.socket = new Socket(inetAddress, port);
        this.runClient();
    }

    public void runClient() throws IOException {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(),true)){
           String line;
            do{
               line = in.readLine();
                out.write(line);
           }while (!line.equals("stop"));
        }


    }
}
