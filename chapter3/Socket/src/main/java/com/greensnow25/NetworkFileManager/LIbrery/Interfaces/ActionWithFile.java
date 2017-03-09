package com.greensnow25.NetworkFileManager.LIbrery.Interfaces;


import java.io.File;
import java.io.IOException;
import java.net.Socket;

public interface ActionWithFile {
    public void makeAction(String newFilePath, Socket socket) throws IOException;
}
