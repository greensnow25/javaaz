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


    }

    /**
     * arhive file.
     */
    File zipName;
    /**
     * file path.
     */
    File file;
    /**
     * path to directore whose ned zip.
     */
    String path = "D:\\temp";//javaaz\\javaaz\\chapter3";
    /**
     * position on array.
     */
    int position = 0;
    /**
     * patte
     */
    String pattern = ".java";


    String[] toZipFilesPath = new String[30];
    String[] toZirFilesNAme = new String[toZipFilesPath.length];


    String separator = System.getProperty("line.separator");

    String[] parent = new String[10];

    public void makeZipArhive(String path) throws IOException {
        file = new File(path);
        zipName = new File("D:\\chapter.zip");



        try (FileOutputStream fout = new FileOutputStream(zipName);
             ZipOutputStream zout = new ZipOutputStream(fout)) {
            toZipArhive(zout, file, file);
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

    public void toZipArhive(ZipOutputStream zout, File parentDir, File childDir) throws IOException {
        if (parentDir == null || !parentDir.exists()) {
            return;
        }

        File[] files = childDir.listFiles();

        byte[] buffer = new byte[1024];

        zout.setLevel(Deflater.DEFAULT_COMPRESSION);
        for (File filed : files) {
            boolean res = false;
            if (filed.isFile()) {
                if (compareFileNameToPattern(filed, pattern)) {
                    res = true;
                }

            } else if (filed.isDirectory()) {

                res = true;
                toZipArhive(zout, filed, parentDir);

                continue;

            }

            if (res) {

                String name = filed.getAbsolutePath().replace(parentDir.getAbsolutePath(),"");
                zout.putNextEntry(new ZipEntry(name));
                try (FileInputStream fin = new FileInputStream(filed.getAbsolutePath())) {
                    int lennght;

                    while ((lennght = fin.read(buffer)) > -1) {
                        zout.write(buffer, 0, lennght);
                        continue;
                    }


                }

            }
        }
    }

}



