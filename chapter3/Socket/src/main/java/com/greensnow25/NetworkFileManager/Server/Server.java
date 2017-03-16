package com.greensnow25.NetworkFileManager.Server;

import com.greensnow25.NetworkFileManager.LIbrery.Classes.BaseAction;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

/**
 * public class server/
 *
 * @author greensnow25.
 * @version 2.
 * @since 16.03.17.
 */
public class Server {
    public static void main(String[] args) throws IOException {

        Server server = new Server();
        server.starServer();
        server.runAplication();

    }

    /**
     * port for conection.
     */
    private int port;
    /**
     * socket
     */
    private Socket socket;
    /**
     * start directory.
     */
    private String root;

    /**
     * load properties.
     */
    public void properties() throws IOException {
        Properties properties = new Properties();


        try (FileInputStream fileIn = new FileInputStream(new File("").getAbsolutePath()
                + File.separator + "chapter3\\Socket\\src\\main\\java\\resourses"
                + File.separator + "app.resurses.properties")) {
            properties.load(fileIn);
            this.root = properties.getProperty("rootDir");
            String port = properties.getProperty("port");
            this.port = Integer.parseInt(port);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * run server
     *
     * @throws IOException ex.
     */
    private void starServer() throws IOException {
        this.properties();
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

    /**
     * run application.
     *
     * @throws IOException ex.
     */
    public void runAplication() throws IOException {

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true)) {
            BaseAction baseAction = new BaseAction(socket.getInputStream(), socket.getOutputStream(), root);
            String line;
            baseAction.filing();
            do {
                line = in.readLine();
                baseAction.select(line);
            } while (!line.equals("stop"));
        }
    }
}
