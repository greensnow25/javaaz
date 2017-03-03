package com.greensnow25;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * public class  .
 *
 * @author grensnow25.
 * @version 1.
 * @since 01.03.17.
 */
public class ZipProject {
    public static void main(String[] args) throws IOException {

        ZipProject zipProject = new ZipProject();
        zipProject.makeZipArhive(zipProject.path);
        // zipProject.w();
      //  zipProject.toZipArhive(zipProject.toZipFilesPath, zipProject.toZirFilesNAme);

        //  zipProject.createDirectory(zipProject.path,zipProject.zout);

    }

    File zipName;
    ZipOutputStream zout1;
    FileOutputStream fout1;
    File file;
    String path = "D:\\javaaz\\javaaz\\chapter3";
    //  String zipName;

    String[] dir = new String[10];
    int position = 0;
    String pattern = ".java";


    String[] toZipFilesPath = new String[30];
    String[] toZirFilesNAme = new String[toZipFilesPath.length];

    File[] files;


    String separator = System.getProperty("line.separator");

    String[] parent = new String[10];

    public void makeZipArhive(String path) throws IOException {
        file = new File(path);
        files = file.listFiles();


        for (File filed : files) {
            if (filed.isFile()) {
                compareFileNameToPattern(filed, pattern);

            } else if (filed.isDirectory()) {
                makeZipArhive(filed.getPath());

            }
        }
    }

    public void compareFileNameToPattern(File file, String pattern) {

        String fileName = file.getName();
        boolean result = fileName.contains(pattern);
        if (result) {
            toZirFilesNAme[position] = file.getName();
            toZipFilesPath[position++] = file.getAbsolutePath();
        }
    }

    public void w() {
        for (String qq : toZipFilesPath) {
            System.out.println(qq);
        }
        for (String qq : toZirFilesNAme) {
            System.out.println(qq);
        }
    }

    public void toZipArhive(String[] toZipFilesPath, String[] toZipFilesNames,ZipOutputStream zoutZ, File file) throws IOException {

        this.zipName = new File("D:\\chapter.zip");
        try (FileOutputStream fout = new FileOutputStream(zipName);
             ZipOutputStream zout = new ZipOutputStream(fout)) {

            byte[] buffer = new byte[1024];

            zout.setLevel(Deflater.DEFAULT_COMPRESSION);


            for (int i = 0; toZipFilesPath[i] != null; i++) {
                zout.putNextEntry(new ZipEntry(toZipFilesNames[i]));
                try (FileInputStream fin = new FileInputStream(toZipFilesPath[i])) {
                    int lennght;
                    while ((lennght = fin.read(buffer)) > -1) {
                        zout.write(buffer, 0, lennght);
                    }
                    zout.closeEntry();
                }


            }

        }
    }

    public void createDirectory(File file, ZipOutputStream zout) throws IOException {
        String[] qqq = new String[20];
        String[] dirNAme = new String[20];
        int count = 0;
        int countOne = 0;



//            File startFile = new File(path);
//            File[] files = startFile.listFiles();
//
//            for (File fileZ : files) {
//                qqq[countOne++] = fileZ.getAbsolutePath();
//            }
//            for (int i = 0; ; i++) {
//                File fileDest = new File(pathFileName);
//                if (fileDest.getParent().startsWith(path)) {
//                    dirNAme[count++] = fileDest.getName();
//                    pathFileName = fileDest.getParent();
//                    //   String name = fileDest.getName();
//                    System.out.println(fileDest.getParent());
//                } else {
//                    break;
//                }
//
//            }

//            for (int i = 0; i != qqq.length; i++) {
//                for (int j = 0; j != dirNAme.length; j++) {
//                    if (qqq[i].equals(dirNAme[j])) {
//                        zout.putNextEntry(new ZipEntry(dirNAme[j]));
//                      //  createDirectory(toZipFilesPath[i], zout, fout);
//                        try (FileInputStream fin = new FileInputStream(toZipFilesPath[i])) {
//                            int lennght;
//                            while ((lennght = fin.read(buffer)) > -1) {
//                                zout.write(buffer, 0, lennght);
//                            }
//                            zout.closeEntry();
//                        }
//                    }
//                }
//            }



    }


}
