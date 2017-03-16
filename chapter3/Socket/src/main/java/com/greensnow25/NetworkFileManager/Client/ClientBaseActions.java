package com.greensnow25.NetworkFileManager.Client;

import com.greensnow25.NetworkFileManager.LIbrery.Interfaces.Action;

import java.io.*;
import java.net.Socket;

/**
 * public class clientBase.
 *
 * @author greensnow25.
 * @version 1.
 * @since 16.03.17
 */
public class ClientBaseActions {
    /**
     * inputStream.
     */
    private InputStream input;
    /**
     * outputStream.
     */
    private OutputStream output;
    /**
     * write to server.
     */
    private PrintWriter printWriter;
    /**
     * read from client.
     */
    private BufferedReader brFromServer;
    /**
     * Action base.
     */
    private Action[] actions = new Action[6];
    /**
     * sout.
     */
    private PrintWriter println;
    /**
     * keyboard entered.
     */
    private BufferedReader fromKeyboard;

    /**
     * class constructor.
     *
     * @param input  from client.
     * @param output to client.
     */
    public ClientBaseActions(InputStream input, OutputStream output) {
        this.input = input;
        this.output = output;
        this.brFromServer = new BufferedReader(new InputStreamReader(input));
        this.printWriter = new PrintWriter(output, true);
        this.println = new PrintWriter(System.out, true);
        this.fromKeyboard = new BufferedReader(new InputStreamReader(System.in));

    }

    public void filing() {
        int position = 0;
        actions[position++] = this.new ShowDirectory("show", "Show directory");
        actions[position++] = this.new ToParentDirectory("goParent", "Go up to the directory above");
        actions[position++] = this.new ToChildDirectory("goChild", "Move to the directory level below");
        actions[position++] = this.new DownloadFileFromClientToServer("dFile", "Download file from client to serer");
        actions[position++] = this.new DownloadFileFromServerToClient("uFile", "Download file from server to client");
        actions[position++] = this.new Help("help", "Displays the user action menu");
    }

    /**
     * choise action.
     *
     * @param line what the client wants to do.
     * @throws IOException ex.
     */
    public void select(String line) throws IOException {
        boolean bad = false;
        for (int i = 0; i != actions.length; i++) {
            if (line.equals(actions[i].key())) {
                actions[i].makeAction();
                bad = true;
            }
        }
        if (!bad) {
            println.println(brFromServer.readLine());

        }

    }

    /**
     * inner class move to parent directory.
     */
    public class ToParentDirectory extends Action {

        /**
         * constructor.
         *
         * @param key  key.
         * @param info info.
         */
        public ToParentDirectory(String key, String info) {
            super(key, info);
        }

        /**
         * Method moves to the directory one level higher.
         */
        @Override
        public void makeAction() {
            try {
                println.println(brFromServer.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    /**
     * inner class move to child directory.
     */
    public class ToChildDirectory extends Action {


        /**
         * constructor.
         *
         * @param key  key.
         * @param info info.
         */
        public ToChildDirectory(String key, String info) {
            super(key, info);
        }

        @Override
        public void makeAction() {

            try {
                println.println("enter child dir");
                printWriter.println(fromKeyboard.readLine());
                println.println(brFromServer.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * inner class download file from server.
     */
    public class DownloadFileFromServerToClient extends Action {

        /**
         * constructor.
         *
         * @param key  key.
         * @param info info.
         */
        public DownloadFileFromServerToClient(String key, String info) {
            super(key, info);
        }

        @Override
        public void makeAction() throws IOException {
            println.println("Exemple : D:\\doc.txt  ");
            println.println("Enter full file name for downloading to server: ");
            String answer = fromKeyboard.readLine();

            File file = new File(answer);
            printWriter.println(file.getName());
            // brFromServer.readLine();
            try (FileInputStream fileIn = new FileInputStream(file)) {

                long l = file.length();
                printWriter.println(l);
                output.flush();
                int len;
                byte[] buffer = new byte[1024 * 100];

                while ((len = fileIn.read(buffer)) != -1) {
                    output.write(buffer, 0, len);
                    output.flush();

                }
                println.println(brFromServer.readLine());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("File does not exist.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * inner class upload file to server.
     */
    public class DownloadFileFromClientToServer extends Action {

        /**
         * constructor.
         *
         * @param key  key.
         * @param info info.
         */
        public DownloadFileFromClientToServer(String key, String info) {
            super(key, info);
        }

        @Override
        public void makeAction() throws IOException {
            println.println("Exemple : doc.txt  ");
            println.println("Enter full file name for downloading to client: ");
            String answer = fromKeyboard.readLine();
            printWriter.println(answer);
            println.println("Enter the full path directory in which you want to save the file");
            println.println("For exemple : D:\\temp\\");
            String saveDir = fromKeyboard.readLine();
            printWriter.println("ok");
            File file = new File(saveDir + answer);

            try (FileOutputStream fw = new FileOutputStream(file)) {

                String lenght = brFromServer.readLine();
                long lengh = Long.parseLong(lenght);
                boolean exit = true;

                int len;
                long totalLenght = 0;
                byte[] buffer = new byte[1024 * 100];
                while (exit) {
                    len = input.read(buffer);
                    fw.write(buffer, 0, len);
                    totalLenght += len;
                    if (totalLenght == lengh) {
                        exit = false;
                    }

                }
                System.out.println("File successfully downloaded.");
            }
        }
    }

    /**
     * inner class show directory.
     */
    public class ShowDirectory extends Action {

        /**
         * constructor.
         *
         * @param key  key.
         * @param info info.
         */
        public ShowDirectory(String key, String info) {
            super(key, info);
        }

        /**
         * The method sends the client a list of files contained in the directory.
         */
        @Override
        public void makeAction() throws IOException {
            String answer = brFromServer.readLine();
            int len = Integer.parseInt(answer);
            for (int i = 0; i != len; i++) {
                println.println(brFromServer.readLine());
            }
        }
    }

    /**
     * inner class displays a prompt.
     */
    public class Help extends Action {

        /**
         * constructor.
         *
         * @param key  key.
         * @param info info.
         */
        public Help(String key, String info) {
            super(key, info);
        }

        @Override
        public void makeAction() throws IOException {
            String answer = brFromServer.readLine();
            int len = Integer.parseInt(answer);
            for (int i = 0; i != len; i++) {
                println.println(brFromServer.readLine());
            }
        }
    }
}
