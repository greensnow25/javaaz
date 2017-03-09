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
        Socket so = new Socket();
        BotClient botClient = new BotClient(so);
        botClient.client();
    }

    private final String host = "127.0.0.1";
    private final int port = 8189;
    private Socket socket;

    public BotClient(Socket socket) {
        this.socket = socket;
    }

    public void client() throws IOException {
        InetAddress inetAddress = InetAddress.getByName(host);
        try {
            this.socket = new Socket(inetAddress, port);
            this.runClient();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            socket.close();
        }
    }


    public void runClient() throws IOException {


        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                DataInputStream dataIn = new DataInputStream(this.socket.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(this.socket.getOutputStream());
             //   DataInputStream dataIn = new DataInputStream(in)){
        ){
            String line;

            do {
                line = br.readLine();
                dataOut.writeUTF(line);
                    dataOut.flush();

              System.out.println("server request : " + line);
              String request =   dataIn.readUTF();

                System.out.println("response from the server : " + request);
            } while (!line.equals("quit"));

        }
    }
}
