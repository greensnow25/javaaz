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

    private Thread one;

    private Thread two;

    private long wait;

    /**
     * constructor.
     *
     * @param line Analysis string.
     */
    public WordsSpacesCounting(String line) {
        this.line = line;
        this.wait = 1000;
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
     *
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
        this.one = new Thread(new Runnable() {
            @Override
            public void run() {
                if (one.isInterrupted()) {
                    return;
                }
                System.out.printf("%s %d%s", "Number of words", countWords(), separator);
            }
        });
        one.start();
        this.two = new Thread(new Runnable() {
            @Override
            public void run() {
                if (two.isInterrupted()) {
                    return;
                }
                System.out.printf("%s %d%s", "Number of spaces", countSpaces(), separator);
            }
        });
        this.two.start();

        try {
            one.join(this.wait);
            two.join(this.wait);
            one.interrupt();
            two.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * psvm.
     *
     * @param args args.
     */
    public static void main(String[] args) throws InterruptedException {
        WordsSpacesCounting word = new WordsSpacesCounting("wdwed ewf ewf wefwe f ef dsf sd f we2 7");
        for (int i = 0; i != 5; i++) {
            System.out.println("start");
            word.runThreads();

            word.two.join();
            System.out.println("finish");
        }

    }
}
