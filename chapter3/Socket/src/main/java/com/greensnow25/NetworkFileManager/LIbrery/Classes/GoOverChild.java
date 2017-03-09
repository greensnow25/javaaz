package com.greensnow25.NetworkFileManager.LIbrery.Classes;


import com.greensnow25.NetworkFileManager.LIbrery.Interfaces.Parse;

import java.io.File;

public class GoOverChild implements Parse {
    public static void main(String[] args) {
        File file = new File("D:\\temp\\");
        GoOverChild go = new GoOverChild(file, "java-a-to-z");
        go.goOver();
    }
    private File parentDir;
    private String childDir;

    public GoOverChild(File parentDir, String childDir){
        this.parentDir = parentDir;
        this.childDir = childDir;
    }

    @Override
    public File goOver() {
        String name =parentDir.getName();
        String path = parentDir.getAbsolutePath();
        String newPath = String.format(path+ "\\"+this.childDir);
        File child = new File(newPath);
        return child;
    }
}
