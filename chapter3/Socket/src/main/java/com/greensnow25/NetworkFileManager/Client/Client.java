package com.greensnow25.NetworkFileManager.Client;

import com.greensnow25.NetworkFileManager.LIbrery.Classes.BaseAction;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;

import static com.oracle.jrockit.jfr.DataType.UTF8;

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
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
             PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true)) {
            String line;
            boolean exit = true;
            do {
                System.out.println("Aplication is runing. Enter help if you need help");
                line = in.readLine();
                out.println(line);
                if (line.equals("dFile")) {
                    downFromServerToClient(in, out, fromServer);
                } else if (line.equals("uFile")) {
                    uploadFromClienToServer(in, out);
                } else if (line.equals("goChild")) {
                    String answer = in.readLine();
                    out.println(answer);
                }

                while (fromServer.ready()) {
                    String answer = fromServer.readLine();//поток приходит с опозданием на одну операцию
                    System.out.println(answer);
                }
            } while (!line.equals("stop"));
        }


    }

    /**
     * method download file from serwer to client.
     *
     * @param in         BufferedReader, read wrom keyboard.
     * @param out        PrintWriter, write to socket.
     * @param fromServer BufferedReader, read from socket.
     * @throws IOException ex.
     */
    public void downFromServerToClient(BufferedReader in, PrintWriter out, BufferedReader fromServer) throws IOException {
        System.out.print("Enter full file name: ");
        String answer = in.readLine();
        out.println(answer);
        System.out.println("Enter the full path directory in which you want to save the file");
        System.out.println("For exemple : D:\\temp\\");
        String saveDir = in.readLine();
        out.println("ok");
        File file = new File(saveDir + answer);

        try (FileOutputStream fw = new FileOutputStream(file)) {

            String lenght = fromServer.readLine();
            long lengh = Long.parseLong(lenght);
            boolean exit = true;

            int len;
            long totalLenght = 0;
            byte[] buffer = new byte[1024 * 100];

            while (exit) {
                len = socket.getInputStream().read(buffer);
                fw.write(buffer, 0, len);
                totalLenght += len;
                if (totalLenght == lengh) {
                    exit = false;
                }
            }
            System.out.println("File successfully downloaded.");
        }
    }

    /**
     * method upload file from client to server.
     *
     * @param in  BufferedReader, read wrom keyboard.
     * @param out PrintWriter, write to socket.
     * @throws IOException ex.
     */
    public void uploadFromClienToServer(BufferedReader in, PrintWriter out) throws IOException {
        System.out.println("Enter full path to file");
        String fileToUpload = in.readLine();
        File file = new File(fileToUpload);
        String fileName = file.getName();
        out.println(fileName);
        try (FileInputStream fileIn = new FileInputStream(file)) {
            long fileLenght = file.length();
            out.println(fileLenght);
            int len;
            byte[] buffer = new byte[1024 * 100];
            while ((len = fileIn.read(buffer)) != -1) {
                socket.getOutputStream().write(buffer, 0, len);
                socket.getOutputStream().flush();
            }
        }
    }


}
