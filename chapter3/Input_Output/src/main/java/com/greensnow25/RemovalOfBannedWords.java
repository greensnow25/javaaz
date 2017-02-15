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
     * abuses word.
     */
    private String badWord1 = "world";

    /**
     * method creates an input and output streams, reads and displays the message.
     *
     * @param in       stream in.
     * @param out      stream out.
     * @param badWords abuses words.
     */
    void dropAbuses(InputStream in, OutputStream out, String badWords) {
        String result;
        try (BufferedReader brIn = new BufferedReader(new InputStreamReader(in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {
            String line = brIn.readLine();
            result = checkFirstCharAbuse(line, badWords);
            bw.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * method looks for matching symbols.
     *
     * @param line  the entered string.
     * @param abuse bad word.
     * @return string without bad words.
     */
    public String checkFirstCharAbuse(String line, String abuse) {
        String result;
        //the position at which the bad word begins.
        int startPos;
        //the position at which the bad word finisf.
        int finishPos;
        //position to use the incremental removal of bad words.
        int countCharsPosition = 0;
        //Character counter at a bad word.
        int count = 0;

        char[] lineChars = line.toCharArray();
        char[] abuseOnChar = abuse.toCharArray();

        for (int i = 0; i != lineChars.length; i++) {
            //the first character in a bad word.
            if (lineChars[i] == abuseOnChar[0]) {

                for (int j = countCharsPosition; j != abuseOnChar.length; j++) {
                    if (lineChars[i + j] == abuseOnChar[j]) {
                        count++;
                        //If the condition is met if the entire word is found.
                        if (count == abuseOnChar.length) {
                            startPos = i;
                            finishPos = j + i;

                            lineChars = deleteAbuse(lineChars, startPos, finishPos);

                            count = 0;
                            countCharsPosition = 0;
                        }
                    } else {
                        count = 0;
                        break;
                    }
                }
            }
        }
        result = String.valueOf(lineChars);

        return result;
    }

    /**
     * method removes bad word.
     *
     * @param lineChar  line break on the characters.
     * @param startPos  the position at which the bad word begins.
     * @param finishpos the position at which the bad word finisf.
     * @return line in symbolic representation.
     */
    public char[] deleteAbuse(char[] lineChar, int startPos, int finishpos) {
        int position = 0;
        char[] withOutAbuse = new char[lineChar.length - (finishpos - startPos)];
        for (int i = 0; i != lineChar.length; i++) {

            if (i < startPos || i > finishpos) {
                withOutAbuse[position++] = lineChar[i];
            }
        }

        return withOutAbuse;
    }

}
