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
    String path = "D:\\temp";//javaaz\\javaaz\\chapter3";
    //  String zipName;

    String[] dir = new String[10];
    int position = 0;
    String pattern = ".java";


    String[] toZipFilesPath = new String[30];
    String[] toZirFilesNAme = new String[toZipFilesPath.length];


    String separator = System.getProperty("line.separator");

    String[] parent = new String[10];

    public void makeZipArhive(String path) throws IOException {
        file = new File(path);
        zipName = new File("D:\\temp\\chapter.zip");


        try (FileOutputStream fout = new FileOutputStream(zipName);
             ZipOutputStream zout = new ZipOutputStream(fout)) {
            toZipArhive(zout, file);
            zout.close();
        }

    }

    public boolean compareFileNameToPattern(File file, String pattern) {

        String fileName = file.getName();
        boolean result = fileName.contains(pattern);
        if (result) {
            toZirFilesNAme[position] = file.getName();
            toZipFilesPath[position++] = file.getAbsolutePath();
        }
        return result;
    }

    public void w() {
        for (String qq : toZipFilesPath) {
            System.out.println(qq);
        }
        for (String qq : toZirFilesNAme) {
            System.out.println(qq);
        }
    }

    public void toZipArhive(ZipOutputStream zout, File file) throws IOException {


        File[] files = file.listFiles();

        byte[] buffer = new byte[1024];

        zout.setLevel(Deflater.DEFAULT_COMPRESSION);
        for (File filed : files) {
            boolean res = false;
            if (filed.isFile()) {
                if (compareFileNameToPattern(filed, pattern)) {
                    res = true;
                }

            } else if (filed.isDirectory()) {
                zout.putNextEntry(new ZipEntry(filed.getName()));
                try (FileInputStream fin = new FileInputStream(filed.getAbsolutePath())) {
                    int lennght;
                    while ((lennght = fin.read(buffer)) > -1) {
                        zout.write(buffer, 0, lennght);
                    }
                    // zout.closeEntry();

                }

                toZipArhive(zout, filed);
                res = true;
                continue;

            }

            if (res) {
                zout.putNextEntry(new ZipEntry(filed.getName()));
                try (FileInputStream fin = new FileInputStream(filed.getAbsolutePath())) {
                    int lennght;
                    while ((lennght = fin.read(buffer)) > -1) {
                        zout.write(buffer, 0, lennght);
                    }
                   // zout.closeEntry();

                }

            }
        }
    }

    public void createDirectoryOrFile(String path, ZipOutputStream zout) throws IOException {
        String[] qqq = new String[20];
        String[] dirNAme = new String[20];
        int count = 0;
        int countOne = 0;

    }

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



