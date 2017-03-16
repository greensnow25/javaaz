package com.greensnow25;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.IOException;

/**
 * public class FileSearch.
 *
 * @author greensnow25.
 * @version 1.
 * @since 16.03.17.
 */
public class FileSearch {
    /**
     * main.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        FileSearch fileSearch = new FileSearch();
        fileSearch.run();
    }

    /**
     * run application.
     */
    
    public void run() {
        File file = new File("D:\\fileSearch.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter fileWriter = new PrintWriter(file)) {
            System.out.println("The directory we will be searching for : ");
            String line = br.readLine();
            System.out.println("request");
            String request = br.readLine();
            File startDir = new File(line);
            search(fileWriter, startDir, request);
            System.out.println(file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * search files.
     *
     * @param fileWriter write to file.
     * @param file       dir to start search.
     * @param line       search line.
     */
    public void search(PrintWriter fileWriter, File file, String line) {

        for (File files : file.listFiles()) {
            if (files.isFile()) {
                boolean write = this.compare(files, line);
                if (write) {
                    fileWriter.println(files.getAbsolutePath());
                }
            } else if (files.isDirectory()) {
                this.search(fileWriter, files, line);
            }
        }
    }

    /**
     * compare files.
     *
     * @param file file.
     * @param line search line.
     * @return boolean.
     */
    public boolean compare(File file, String line) {
        StringBuilder sb = new StringBuilder(line);
        boolean write = file.getName().contains(sb);
        return write;
    }

}
