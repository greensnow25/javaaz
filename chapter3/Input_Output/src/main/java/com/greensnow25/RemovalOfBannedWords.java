package com.greensnow25;

import java.io.*;

/**
 * public class RemovalOfBannedWords removes the forbidden words in a stream .
 *
 * @author grensnow25.
 * @version 1.
 * @since 13.02.17.
 */
public class RemovalOfBannedWords {
    /**
     * abuses words.
     */
    private String[] abuse = new String[]{"hello", "world"};

    /**
     * method creates an input and output streams, reads and displays the message.
     * @param in stream in.
     * @param out stream out.
     * @param words abuses words.
     */
    void dropAbuses(InputStream in, OutputStream out, String[] words) {
        String test = "I wrote a program hello world well";
        try (BufferedReader brIn = new BufferedReader(new InputStreamReader(in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {
            String line = brIn.readLine();
            String[] res = checkAbuse(line, words);

            for (String wellWords : res) {
                bw.write(wellWords + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *method removes the bad words.
     * @param line input string.
     * @param abuse array of bad words.
     * @return array with out bad words.
     */
    public String[] checkAbuse(String line, String[] abuse) {
        String[] lineWords = line.split(" ");
        int position = 0;
        for (int i = 0; i != lineWords.length; i++) {
            for (int j = 0; j != abuse.length; j++) {
                if (lineWords[i] != null && abuse[j] != null && lineWords[i].equals(abuse[j])) {
                    lineWords[i] = null;
                    position++;
                }
            }
        }
        String[] lineWithOutAbuse = new String[lineWords.length - position];
        int count = 0;
        for (int i = 0; i != lineWords.length; i++) {
            if (lineWords[i] != null) {
                lineWithOutAbuse[count++] = lineWords[i];
            }
        }
        return lineWithOutAbuse;
    }
}
