package com.greensnow25;

import java.io.*;
import java.util.RandomAccess;
import java.util.Scanner;

/**
 * public class  .
 *
 * @author grensnow25.
 * @version 1.
 * @since 15.02.17.
 */
public class SortLargeFile {
    public static void main(String[] args) throws IOException {

        SortLargeFile sort = new SortLargeFile("\\chapter3\\Input_Output\\src\\main\\java\\com\\greensnow25");
        sort.sortFile();
        sort.split();
        sort.merge();

    }

    public SortLargeFile(String path) throws FileNotFoundException {
        this.path = path;
    }

    private final String userDir = System.getProperty("user.dir");
    private String path;
    private RandomAccessFile fileSourse;
    String separator = System.getProperty("line.separator");
    private RandomAccessFile tempOne;
    private RandomAccessFile tempTwo;
    String one1;
    String two2;


    public void sortFile() throws IOException {

    }

    String line;
    String tempLine;

    public void split() throws IOException {


        boolean firstLine = false;
        int count = 2;
        try (RandomAccessFile fileSourse = new RandomAccessFile(userDir + path + "\\test.txt", "rw");
             RandomAccessFile tempOne = new RandomAccessFile(userDir + path + "\\tempOne.txt", "rw");
             RandomAccessFile tempTwo = new RandomAccessFile(userDir + path + "\\temptwo.txt", "rw");) {


            while ((line = fileSourse.readLine()) != null) {
                if (!firstLine) {
                    firstLine = true;
                } else if (tempLine.length() >= line.length() && tempLine != null) {
                    count++;
                }
                if (count % 2 == 0) {
                    tempOne.writeBytes(line);
                    tempOne.writeBytes(separator);


                } else if (count % 2 != 0) {
                    tempTwo.writeBytes(line);
                    tempTwo.writeBytes(separator);
                }
                tempLine = line;
            }

        }


    }

    public void merge() throws IOException {
        try (RandomAccessFile fileSourseOne = new RandomAccessFile(userDir + path + "\\testOne.txt", "rw");
             RandomAccessFile tempOne = new RandomAccessFile(userDir + path + "\\tempOne.txt", "rw");
             RandomAccessFile tempTwo = new RandomAccessFile(userDir + path + "\\temptwo.txt", "rw");) {

            String one;
            String two = tempTwo.readLine();


            RandomAccessFile big = tempOne.length()-1 > tempTwo.length()-1 ? tempOne : tempTwo;


            while ((one = big.readLine()) != null) {
                tempOne.seek(0);
                if (one.length() < two.length()) {
                    fileSourseOne.writeBytes(one);
                    fileSourseOne.writeBytes(separator);


                } else if (two.length() < one.length()) {
                    fileSourseOne.writeBytes(two);
                    fileSourseOne.writeBytes(separator);
                    two = tempTwo.readLine();
                }
            }

        }
    }

}

