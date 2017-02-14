package com.greensnow25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * public class CheckByteStream check in that the recorded bit stream is an even number.
 *
 * @author grensnow25.
 * @version 1.
 * @since 13.02.17.
 */
public class CheckByteStream {
    /**
     * method check in that the recorded bit stream is an even number.
     *
     * @param in input stream.
     * @return boolean value.
     */
    public boolean isNumber(InputStream in) {
        boolean result = false;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            int line = Integer.parseInt(br.readLine());
            if (line % 2 == 0) {
                result = true;
            } else {
                System.out.println("This number is odd");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
