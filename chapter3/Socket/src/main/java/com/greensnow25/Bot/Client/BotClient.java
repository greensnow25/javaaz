package com.greensnow25.Bot.Client;

import com.greensnow25.Bot.Server.BotServer;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * public class BotClient.
 *
 * @author greensnow25.
 * @version 2.
 * @siense 07.03.17.
 */
public class BotClient {

    public static void main(String[] args) throws IOException {
        BotClient botClient = new BotClient();
        botClient.runClient();
    }

    private String host = "127.0.0.1";
    private int port = 8189;

    public void runClient() throws IOException {
        Socket socketClient = null;
        InetAddress inetAddress = InetAddress.getByName(host);
        try {
            socketClient = new Socket(inetAddress, port);
            System.out.println("conecning to the server with ip : " + inetAddress + "  port  " + port);
            InputStream in = socketClient.getInputStream();
            OutputStream out = socketClient.getOutputStream();


            try (DataInputStream dIn = new DataInputStream(in);
                 DataOutputStream dOut = new DataOutputStream(out);
                 BufferedReader readerKeyboard = new BufferedReader(new InputStreamReader(System.in));) {
                String line;
                do {
                    line = readerKeyboard.readLine();
                    System.out.println("server request : " + line);
                    dOut.writeUTF(line);

                    System.out.println("response from the server : " + dIn.readUTF());
                } while (!line.equals("quit"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            socketClient.close();
        }
    }
}