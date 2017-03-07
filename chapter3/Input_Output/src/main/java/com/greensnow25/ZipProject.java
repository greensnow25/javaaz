package com.greensnow25;

import java.io.*;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * public class ZipProgrct arhive progect .
 *
 * @author grensnow25.
 * @version 1.
 * @since 01.03.17.
 */
public class ZipProject {
//    public static void main(String[] args) throws IOException {
//
//        ZipProject zipProject = new ZipProject();
//        zipProject.makeZipArhive(zipProject.path, zipProject.zipPath);
//
//
//    }

    /**
     * path to directore whose ned zip.
     */
    String path;
    /**
     * zipDir
     */
    String zipPath;

    /**
     * pattern from search.
     */
    String pattern;

    /**
     * class constructor.
     *
     * @param zipPath zippath.
     * @param path    path directory.
     * @param pattern filter.
     */
    public ZipProject(String zipPath, String path, String pattern) {
        this.zipPath = zipPath;
        this.path = path;
        this.pattern = pattern;
    }

    /**
     * mehhod create archive.
     *
     * @throws IOException ex.
     */
    public void makeZipArhive() {
        File file = new File(path);
        File zipName = new File(zipPath);

        try (FileOutputStream fout = new FileOutputStream(zipName);
             ZipOutputStream zout = new ZipOutputStream(fout)) {
            toZipArhive(zout, file, file);
            zout.close();
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * method create archive.
     *
     * @param zout      ZipOutputStream.
     * @param parentDir rootDir.
     * @param childDir  currentDir.
     * @throws IOException ex.
     */
    public void toZipArhive(ZipOutputStream zout, File parentDir, File childDir) throws IOException {
        if (parentDir == null || !parentDir.exists()) {
            return;
        }

        File[] files = childDir.listFiles();

        byte[] buffer = new byte[1024];

        zout.setLevel(Deflater.DEFAULT_COMPRESSION);
        for (File filed : files) {

            if (filed.isDirectory()) {
                toZipArhive(zout, parentDir, filed);

            } else if (filed.getName().contains(pattern)) {
                String name = filed.getAbsolutePath().replace(parentDir.getAbsolutePath(), "");
                zout.putNextEntry(new ZipEntry(name));
                try (FileInputStream fin = new FileInputStream(filed.getAbsolutePath())) {
                    int lennght;

                    while ((lennght = fin.read(buffer)) > -1) {
                        zout.write(buffer, 0, lennght);
                    }
                }
            }
        }
    }
}



