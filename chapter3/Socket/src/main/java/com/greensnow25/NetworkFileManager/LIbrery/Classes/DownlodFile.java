package com.greensnow25.NetworkFileManager.LIbrery.Classes;


import com.greensnow25.NetworkFileManager.LIbrery.Interfaces.ActionWithFile;

import java.io.*;
import java.net.Socket;

public class DownlodFile implements ActionWithFile {
    public static void main(String[] args) {
        DownlodFile downlodFile = new DownlodFile();
        //downlodFile.makeAction();
    }


    @Override
    public void makeAction(String newFilePath, Socket socket) throws IOException {

        File file = new File(newFilePath);

        BufferedOutputStream bis = null;
        try {
             bis = new BufferedOutputStream(new FileOutputStream(file));
            BufferedInputStream bisSocket = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream bosSocket = new BufferedOutputStream(socket.getOutputStream());

            int len;
            byte[] buffer = new byte[2048];
            while((len = bisSocket.read(buffer))>0 ){
                bis.write(buffer,0,len);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            bis.close();
        }

    }
}
