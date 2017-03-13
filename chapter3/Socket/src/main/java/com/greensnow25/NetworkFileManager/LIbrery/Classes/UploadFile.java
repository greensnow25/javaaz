package com.greensnow25.NetworkFileManager.LIbrery.Classes;

import com.greensnow25.NetworkFileManager.LIbrery.Interfaces.ActionWithFile;

import java.io.*;
import java.net.Socket;

public class UploadFile implements ActionWithFile {
    @Override
    public void makeAction(File filePath, Socket socket, long lenght, String answer) throws IOException {
        BufferedInputStream bis = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(filePath));
          //  BufferedInputStream bisSocket = new BufferedInputStream(socket.getInputStream());
           DataOutputStream boutSocket = new DataOutputStream(socket.getOutputStream());
            int len;
            byte[] buffer = new byte[2048];


            while ((len = bis.read(buffer)) != -1) {
                boutSocket.write(buffer, 0, len);

                if (len == (int) lenght) {
                    break;

                }
                boutSocket.flush();
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
