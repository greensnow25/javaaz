package com.greensnow25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * public class WordsSpacesCounting.
 *
 * @author greensnow25.
 * @version 1.
 * @since 08.06.2017.
 */
public class WordsSpacesCounting {
    /**
     * Analysis string.
     */
    private String line;
    /**
     * separator.
     */
    private final String separator = System.getProperty("line.separator");

    /**
     * constructor.
     *
     * @param line Analysis string.
     */
    public WordsSpacesCounting(String line) {
        this.line = line;
    }

    /**
     * Method counts words.
     *
     * @return number of words.
     */
    public int countWords() {
        int count = 0;
        Pattern pattern = Pattern.compile("\\w*[^\\s*]");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    /**
     * Method counts spaces.
     * @return number of spaces.
     */
    public int countSpaces() {
        int count = 0;
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    /**
     * Method run threads.
     */
    public void runThreads() {
        new Thread() {
            @Override
            public void run() {
                System.out.printf("%s %d%s", "Number of words", countWords(), separator);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                System.out.printf("%s %d%s", "Number of spaces", countSpaces(), separator);
            }
        }.start();
    }

    /**
     * psvm.
     * @param args args.
     */
    public static void main(String[] args) {
        WordsSpacesCounting word = new WordsSpacesCounting("wdwed ewf ewf wefwe f ef dsf sd f we2 7");
        for (int i = 0; i != 5; i++) {
            word.runThreads();
        }

    }
}
