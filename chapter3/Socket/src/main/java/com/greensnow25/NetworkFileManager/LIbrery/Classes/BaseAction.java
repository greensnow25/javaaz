package com.greensnow25.NetworkFileManager.LIbrery.Classes;

import com.greensnow25.NetworkFileManager.LIbrery.Interfaces.Action;

import java.io.*;

/**
 * public class BaseAction, contain all actions of network file manager.
 *
 * @author greensnow25.
 * @version 2.
 * @siense 15.03.2017.
 */
public class BaseAction {
    /**
     * inputStream.
     */
    private InputStream input;
    /**
     * outputStream.
     */
    private OutputStream output;
    /**
     * root Directory.
     */
    private String rootDir;
    /**
     * write to server.
     */
    private PrintWriter printWriter;
    /**
     * read from client.
     */
    private BufferedReader br;
    /**
     * Action base.
     */
    private Action[] actions = new Action[6];

    /**
     * class constructor.
     *
     * @param input   from client.
     * @param output  to client.
     * @param rootDir current directory.
     */
    public BaseAction(InputStream input, OutputStream output, String rootDir) {
        this.input = input;
        this.output = output;
        this.rootDir = rootDir;
        this.br = new BufferedReader(new InputStreamReader(input));
        this.printWriter = new PrintWriter(output, true);
    }

    /**
     * filling base action.
     */
    public void filing() {
        int position = 0;
        actions[position++] = this.new ShowDirectory("show", "Show directory");
        actions[position++] = this.new ToParentDirectory("goParent", "Go up to the directory above");
        actions[position++] = this.new ToChildDirectory("goChild", "Move to the directory level below");
        actions[position++] = this.new DownloadFileFromClientToServer("uFile", "Download file from client to serer");
        actions[position++] = this.new DownloadFileFromServerToClient("dFile", "Download file from server to client");
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
            printWriter.println("Bad comand try again.");
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
            char[] lineToChar = rootDir.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = lineToChar.length - 1; i > 0; i--) {
                sb.append(lineToChar[i]);
                if (lineToChar[i] == '\\') {
                    sb.reverse();
                    rootDir = rootDir.replace(sb.toString(), " ");
                    sb.delete(0, sb.length());
                    break;
                } else if (lineToChar.length == 3) {
                    printWriter.println("You are not in the root directory");
                    sb.delete(0, sb.length());
                    break;
                }
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

            String lineName;
            try {
                lineName = br.readLine();
                rootDir = rootDir + "\\" + lineName;

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
            String answer = br.readLine();
            File file = new File(rootDir + answer);
            answer = br.readLine();
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
                printWriter.println("The file from the server was successfully transferred");

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
            String answer = br.readLine();

            File file = new File("D:\\" + answer);
            try (FileOutputStream fileOut = new FileOutputStream(file)) {
                String lenght = br.readLine();
                long fileLenght = Long.parseLong(lenght);
                int len;
                int total = 0;
                boolean exit = true;
                byte[] buffer = new byte[1024 * 100];
                while (exit) {
                    len = input.read(buffer);
                    fileOut.write(buffer, 0, len);
                    total += len;
                    if (total == fileLenght) {
                        exit = false;
                    }
                }
                printWriter.println("The file was successfully received on the server side");
                printWriter.println("The file is located at" + file.getAbsolutePath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
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
        public void makeAction() {
            File file = new File(rootDir);
            for (String files : file.list()) {
                printWriter.println(files);
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
        public void makeAction() {

            for (int i = 0; i != actions.length; i++) {
                if (actions[i] != null) {
                    printWriter.println(actions[i].info());
                }
            }
        }
    }

}
