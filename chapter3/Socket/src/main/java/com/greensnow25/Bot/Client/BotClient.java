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
            socket = new Socket(inetAddress, port);
            this.runClient();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            socket.close();
        }
    }


    public void runClient() throws IOException {
        InputStream in = this.socket.getInputStream();
        OutputStream out = this.socket.getOutputStream();

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader dIn = new BufferedReader(new InputStreamReader(in));
                DataOutputStream dataOut = new DataOutputStream(out)) {
            String line = null;

            do {
                line = br.readLine();
                dataOut.writeUTF(line);


                System.out.println("server request : " + line);
                dIn.readLine();

                System.out.println("response from the server : " + dIn.readLine());
            } while (!line.equals("quit"));

        }
    }
}
