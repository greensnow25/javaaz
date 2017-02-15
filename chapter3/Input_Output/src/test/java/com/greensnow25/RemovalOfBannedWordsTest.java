package com.greensnow25;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * public class RemovalOfBannedWordsTest.
 *
 * @author grensnow25.
 * @version 1.
 * @since 15.02.17.
 */
public class RemovalOfBannedWordsTest {
    /**
     * method checks whether there is a forbidden word in the sentence.
     *
     * @throws IOException ex.
     */
    @Test
    public void dropAbuses() throws IOException {
        RemovalOfBannedWords rm = new RemovalOfBannedWords();
        String test = "ВасяПетяВасяКостяВася";
        String result = "ПетяКостя";
        String abuse = "Вася";

        try (ByteArrayOutputStream outer = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(outer));

            InputStream inputStream = new ByteArrayInputStream(test.getBytes());
            PrintStream printOut = System.out;

            rm.dropAbuses(inputStream, printOut, abuse);
            String out = outer.toString();
            assertThat(result, is(out));

        }
    }

}