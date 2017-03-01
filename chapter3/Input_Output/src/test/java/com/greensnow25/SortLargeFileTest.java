package com.greensnow25;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * public testClass SortLargeFileTest .
 *
 * @author grensnow25.
 * @version 1.
 * @since 28.02.17.
 */
public class SortLargeFileTest {
    /**
     * test array.
     */
    private String[] testo = new String[]{"999999999", "1", "55555", "333", "4444", "333", "666666"};
    /**
     * system didectory.
     */
    private final String userDir = System.getProperty("user.dir");
    /**
     * path to the file.
     */
    private String path = "\\src\\main\\java\\com\\greensnow25\\";

    /**
     * metod sort file.
     */
    @Test
    public void whenSortFileIsSuccessfulThenReturnTrue() {
        SortLargeFile sort = new SortLargeFile();
        String separator = System.getProperty("line.separator");
        boolean result = true;
        String temp;
        String lastLine = "";
        File sourse = new File(userDir + path + "test.txt");
        File dest = new File(userDir + path + "dest.txt");
        try (RandomAccessFile write = new RandomAccessFile(sourse, "rw");
             RandomAccessFile read = new RandomAccessFile(dest, "rw")) {
            for (String line : testo) {
                write.writeBytes(line);
                write.writeBytes(separator);
            }
            sort.sortFile(sourse, dest);

            while ((temp = read.readLine()) != null) {

                if (lastLine.length() > temp.length()) {
                    result = false;
                }
                lastLine = temp;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        assertThat(result, is(true));
    }
}