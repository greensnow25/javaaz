package com.greensnow25.NetworkFileManager.LIbrery.Classes;


import com.greensnow25.NetworkFileManager.LIbrery.Interfaces.ActionWithFile;

import java.io.*;
import java.net.Socket;

public class DownlodFile implements ActionWithFile {
//    public static void main(String[] args) {
//        DownlodFile downlodFile = new DownlodFile();
//        //downlodFile.makeAction();
//    }


    @Override
    public void makeAction(File filePath, Socket socket, long lenght, String answer) throws IOException {


        try {

            FileOutputStream bis = new FileOutputStream(filePath);
            DataInputStream bisSocket = new DataInputStream(socket.getInputStream());
            DataOutputStream bosSocket = new DataOutputStream(socket.getOutputStream());

            int len;
            byte[] buffer = new byte[2048];
            while ((len = bisSocket.read(buffer)) != -1) {
                bis.write(buffer, 0, len);
                bosSocket.writeUTF(answer);
                long langFile = bisSocket.readLong();

                if (len == (int) langFile) {
                    break;

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
