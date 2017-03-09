package com.greensnow25.Bot.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * public class BotServer.
 *
 * @author greensnow25.
 * @version 2.
 * @siense 07.03.17.
 */
public class BotServer {
    public static void main(String[] args) throws IOException {
       Socket socket = new Socket();
        BotServer botServer = new BotServer(socket);
        botServer.botServer();
    }

    /**
     * socket port.
     */
    private int port = 8189;

    private Socket socket;


    public BotServer(Socket socket) {
        this.socket = socket;
    }

    private String[] randomWords = new String[]{"Hello", "how are you", "Smart Bot"};

    public void botServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("waiting for conections...");
        socket = serverSocket.accept();
        System.out.println("conecting esteblished");
        runServer();


    }

    public void runServer() {

        try (InputStream in = this.socket.getInputStream();
             OutputStream out = this.socket.getOutputStream();
             DataInputStream dIn = new DataInputStream(in);
             PrintWriter dOut = new PrintWriter(out, true);) {

            String line = null;
            int position = 0;
            do {

                line = dIn.readUTF();
                System.out.println("word from client " + line);
                if (position == randomWords.length) {
                    position = 0;
                }
                dOut.println(randomWords[position++]);
                dOut.flush();


            }
            while (!line.equals("quit"));
            dOut.println(line);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

