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
     * method find the word abuse delete it.
     *
     * @throws IOException ex.
     */
    @Test
    public void whenFindTheAbuseWordThenDeleteIt() throws IOException {
        RemovalOfBannedWords rm = new RemovalOfBannedWords();
        String test = "ВасяПетяВасяКостяВася";
        String result = "ПетяКостя";
        String abuse = "Вася";

        try (ByteArrayInputStream in = new ByteArrayInputStream(test.getBytes());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(out));
            rm.dropAbuses(in, out, abuse);
            String outSting = out.toString();
            assertThat(result, is(outSting));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * method method find the word if abusse equel null then return result.
     *
     * @throws IOException ex.
     */
    @Test
    public void whenNoAbuseWordThenPrintLine() throws IOException {
        RemovalOfBannedWords rm = new RemovalOfBannedWords();
        String test = "ВасяПетяВасяКостяВася";
        String abuse = "Даша";

        try (ByteArrayInputStream in = new ByteArrayInputStream(test.getBytes());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(out));
            rm.dropAbuses(in, out, abuse);
            String outSting = out.toString();
            assertThat(test, is(outSting));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * method method find the word abuse delete it.
     *
     * @throws IOException ex.
     */
    @Test
    public void whenAllLineIsAbuseWordThenDeleteAllLine() throws IOException {
        RemovalOfBannedWords rm = new RemovalOfBannedWords();
        String test = "ВасяВасяВася";
        String result = "";
        String abuse = "Вася";

        try (ByteArrayInputStream in = new ByteArrayInputStream(test.getBytes());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(out));
            rm.dropAbuses(in, out, abuse);
            String outSting = out.toString();
            assertThat(result, is(outSting));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}