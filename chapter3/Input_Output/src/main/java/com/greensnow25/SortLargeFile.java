package com.greensnow25;

import java.io.*;

/**
 * public class  .
 *
 * @author grensnow25.
 * @version 1.
 * @since 15.02.17.
 */
public class SortLargeFile {

    /**
     * the directory in which the application was launched
     */
    private final String userDir = System.getProperty("user.dir");
    /**
     * path to the file.
     */
    private String path = "\\src\\main\\java\\com\\greensnow25\\";
    /**
     * the transfer carriage.
     */
    private final String separator = System.getProperty("line.separator");
    /**
     * variable defines the maximum length of the line in the first file.
     */
    private int resultOne = 0;
    /**
     * variable defines the maximum length of the line in the second file.
     */
    private int resultTwo = 0;
    /**
     * a pointer to a file for later use.
     */
    private int whereYouSplit = 0;
    /**
     * a flag indicating that the file is sorted.
     */
    private boolean endSort = true;

    /**
     * method splits into two series of image file.
     *
     * @param sourse sourse file.
     * @throws IOException an attempt to write to a file.
     */
    public void split(File sourse) throws IOException {

        String line;
        String tempLine = "";
        boolean firstLine = false;
        int count = 2;
        try (RandomAccessFile fileSourse = new RandomAccessFile(sourse, "rw");
             RandomAccessFile tempOne = new RandomAccessFile(userDir + path + "tempOne.txt", "rw");
             RandomAccessFile tempTwo = new RandomAccessFile(userDir + path + "temptwo.txt", "rw");
             RandomAccessFile fileSourseOne = new RandomAccessFile(userDir + path + "testOne.txt", "rw")) {

            RandomAccessFile whereSplit = whereYouSplit == 0 ? fileSourse : fileSourseOne;

            while ((line = whereSplit.readLine()) != null) {
                if (!firstLine) {
                    firstLine = true;
                } else if (tempLine.length() > line.length()) {
                    count++;
                }
                if (count % 2 == 0) {
                    tempOne.writeBytes(line);
                    tempOne.writeBytes(separator);
                    resultOne = maxLenght(resultOne, line);

                } else if (count % 2 != 0) {
                    tempTwo.writeBytes(line);
                    tempTwo.writeBytes(separator);
                    resultTwo = maxLenght(resultTwo, line);
                }
                tempLine = line;
            }
            fileSourseOne.setLength(0);
        }
    }

    /**
     * method uses an external sort, and merges the data in the destination file.
     *
     * @param dest destinstion file.
     * @throws IOException an attempt to write to a file.
     */
    public RandomAccessFile merge(File dest) throws IOException {
        RandomAccessFile result = null;
        try (RandomAccessFile fileSourseOne = new RandomAccessFile(dest, "rw");
             RandomAccessFile tempOne = new RandomAccessFile(userDir + path + "\\tempOne.txt", "rw");
             RandomAccessFile tempTwo = new RandomAccessFile(userDir + path + "\\temptwo.txt", "rw")) {

            String one;
            String last;
            boolean inerExit;
            RandomAccessFile small = resultOne < resultTwo ? tempOne : tempTwo;
            RandomAccessFile big = resultOne > resultTwo ? tempOne : tempTwo;
            String two = big.readLine();

            while ((one = small.readLine()) != null) {
                inerExit = true;
                while (inerExit) {

                    if (one.length() < two.length()) {
                        fileSourseOne.writeBytes(one);
                        fileSourseOne.writeBytes(separator);
                        inerExit = false;

                    } else if (two.length() < one.length() && two != null) {
                        fileSourseOne.writeBytes(two);
                        fileSourseOne.writeBytes(separator);
                        two = big.readLine();

                    } else if (two.length() == one.length()) {
                        fileSourseOne.writeBytes(one);
                        fileSourseOne.writeBytes(separator);
                        fileSourseOne.writeBytes(two);
                        fileSourseOne.writeBytes(separator);
                        inerExit = false;
                        if ((two = big.readLine()) != null) {
                        }
                    }
                }
            }
            if (one == null || two == null) {
                fileSourseOne.writeBytes(two);
                fileSourseOne.writeBytes(separator);
            }
            while ((last = big.readLine()) != null) {
                fileSourseOne.writeBytes(last);
                fileSourseOne.writeBytes(separator);
            }
            if (tempOne.length() == 0 || tempTwo.length() == 0) {
                endSort = false;
                result = fileSourseOne;
            }
            whereYouSplit = 1;
            resultOne = 0;
            resultTwo = 0;
            tempOne.setLength(0);
            tempTwo.setLength(0);
        }
        return result;
    }

    /**
     * method sort the file.
     *
     * @param sourse sourse file.
     * @param dest   destinstion file.
     * @return result.
     * @throws IOException ex.
     */
    public RandomAccessFile sortFile(File sourse, File dest) throws IOException {
        RandomAccessFile result = null;
        while (endSort) {
            split(sourse);
            result = merge(dest);
        }
        return result;
    }

    /**
     * method finds the longest string.
     *
     * @param one  max value.
     * @param line value to test.
     * @return max value.
     */
    public int maxLenght(int one, String line) {
        int result;
        if (one >= line.length()) {
            result = one;
        } else {
            result = line.length();
        }
        return result;
    }
}

