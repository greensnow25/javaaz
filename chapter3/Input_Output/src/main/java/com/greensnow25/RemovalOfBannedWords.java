package com.greensnow25;

import java.io.*;
import java.nio.CharBuffer;

/**
 * public class RemovalOfBannedWords removes the forbidden words in a stream .
 *
 * @author grensnow25.
 * @version 1.
 * @since 13.02.17.
 */
public class RemovalOfBannedWords {

    /**
     * method creates an input and output streams, reads and displays the message.
     *
     * @param in       stream in.
     * @param out      stream out.
     * @param badWords abuse word.
     * @throws IOException ex.
     */
    void dropAbuses(InputStream in, OutputStream out, String badWords) throws IOException {
        char[] badWordsArray = badWords.toCharArray();
        int position = 0;
        int streamCharInt;
        boolean firstChar = false;
        StringBuilder sb = new StringBuilder();
        try (InputStreamReader reader = new InputStreamReader(in);
             OutputStreamWriter writer = new OutputStreamWriter(out)) {
            while ((streamCharInt = reader.read()) > 0) {

                char streamChar = (char) streamCharInt;
                sb.append(streamChar);
                if (badWordsArray[0] == streamChar || firstChar == true) {
                    firstChar = true;
                    for (int i = position; i != badWordsArray.length; i++) {
                        if (badWordsArray[i] == streamChar) {
                            position++;
                            if (position == badWordsArray.length) {
                                sb.delete(0, badWordsArray.length);
                                firstChar = false;
                                position = 0;
                            } else {
                                break;
                            }
                        } else {
                            writer.write(sb.toString());
                            sb.delete(0, sb.length());
                            break;
                        }
                    }
                } else if (!firstChar) {
                    writer.write(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
