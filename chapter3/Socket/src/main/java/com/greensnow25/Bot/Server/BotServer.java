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
    /**
     * socket.
     */
    private Socket socket;
    /**
     * answers to client.
     */
    private final String[] randomWords = new String[]{"Hello", "how are you", "Smart Bot"};

    /**
     * class constructor.
     *
     * @param socket socket.
     */
    public BotServer(Socket socket) {
        this.socket = socket;
    }

    /**
     * run server.
     *
     * @throws IOException ex.
     */
    public void botServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("waiting for conections...");
        this.socket = serverSocket.accept();
        System.out.println("conecting esteblished");
        runServer();
        serverSocket.close();
        socket.close();

    }

    public void runServer() {

        try (DataInputStream dIn = new DataInputStream(this.socket.getInputStream());
             DataOutputStream dataOut = new DataOutputStream(this.socket.getOutputStream())) {

            String line;
            int position = 0;

            do {
                line = dIn.readUTF();
                System.out.println("word from client " + line);
                if (position == randomWords.length) {
                    position = 0;
                }
                dataOut.writeUTF(randomWords[position++] + System.getProperty("line.separator"));
            }
            while (!line.equals("quit"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

