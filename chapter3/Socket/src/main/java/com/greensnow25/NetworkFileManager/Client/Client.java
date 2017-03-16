package com.greensnow25.NetworkFileManager.Client;

import com.greensnow25.NetworkFileManager.LIbrery.Classes.BaseAction;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;

/**
 * public class Client.
 *
 * @author greensnow25.
 * @version 1.
 * @since 16.03.17.
 */
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Client client = new Client();
        client.conectServer();
    }

    /**
     * server ip.
     */
    private String host;
    /**
     * port for connect.
     */
    private int port;
    /**
     * socket.
     */
    private Socket socket;

    /**
     * read properties from file.
     */
    public void readProperties() {
        Properties properties = new Properties();
        try (FileInputStream fileIn = new FileInputStream(new File("").getAbsolutePath()
                + File.separator + "chapter3\\Socket\\src\\main\\java\\resourses"
                + File.separator + "app.resurses.properties")) {
            properties.load(fileIn);

            this.host = properties.getProperty("host");
            String port = properties.getProperty("port");
            this.port = Integer.parseInt(port);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * connect to server.
     *
     * @throws IOException ex.
     */
    public void conectServer() throws IOException {

        this.readProperties();
        InetAddress inetAddress = InetAddress.getByName(host);
        this.socket = new Socket(inetAddress, port);
        this.runClient();
    }

    public void runClient() throws IOException {
       ClientBaseActions clientBaseActions = new ClientBaseActions(socket.getInputStream(),socket.getOutputStream());
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true)) {
            String line ;
            clientBaseActions.filing();
            while (socket.isConnected()) {
                System.out.println("Aplication is runing. Enter help if you need help");
                line = in.readLine();
                out.println(line);
                clientBaseActions.select(line);
            }
        }
    }
}
