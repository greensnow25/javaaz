package com.greensnow25.NetworkFileManager.LIbrery.Classes;


import com.greensnow25.NetworkFileManager.LIbrery.Interfaces.Parse;

import java.io.File;

public class GoOverParent implements Parse {

//    public static void main(String[] args) {
//        File file = new File("D:\\temp\\");
//        GoOverParent go = new GoOverParent(file);
//        go.goOver();
//    }

    private File parentDir;

    private File childDr;

    public GoOverParent(File fileParentDir, File childDr){
        this.parentDir = fileParentDir;
        this.childDr = childDr;
    }
    @Override
    public File goOver() {
       String name =  this.parentDir.getName();
        String path = this.parentDir.getAbsolutePath();
        String newNameDir = path.replace(name, "");
         childDr = new File(newNameDir);
        return childDr;
    }
}
