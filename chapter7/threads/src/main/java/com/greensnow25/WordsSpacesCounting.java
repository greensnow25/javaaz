package com.greensnow25;

import java.util.concurrent.*;
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
     * Thread delay time.
     */
    private long wait;
    /**
     * ExecutorService .
     */
    private ExecutorService service;

    /**
     * constructor.
     *
     * @param line Analysis string.
     */
    public WordsSpacesCounting(String line) {
        this.line = line;
        this.wait = 1L;
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
    public void runThreads() throws InterruptedException {
        this.service = Executors.newFixedThreadPool(1);
        service.submit(new CountSpaces());
        service.submit(new CountWords());
        service.submit(new Runnable() {
            @Override
            public void run() {
                label:
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("THREAD INTERRUPTED");
                        break label;
                    }
                }
            }
        });
        service.shutdown();
        if (!service.awaitTermination(this.wait, TimeUnit.SECONDS)) {
            service.shutdownNow();
        }
    }

    /**
     * Class counting words.
     */
    private class CountWords extends Thread {
        @Override
        public void run() {
            if (this.isInterrupted()) {
                return;
            }
            System.out.printf("%s %d%s", "Number of words", countWords(), separator);

        }
    }

    /**
     * Class counting spaces.
     */
    private class CountSpaces extends Thread {
        /**
         * run thread.
         */
        @Override
        public void run() {
            if (this.isInterrupted()) {
                return;
            }
            System.out.printf("%s %d%s", "Number of spaces", countSpaces(), separator);

        }
    }

    /**
     * getExecutorServices.
     * @return object.
     */
    public ExecutorService getService() {
        return service;
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

            label:
            while (true) {
                if (!word.getService().isTerminated()) {
                    break label;
                }
            }
            System.out.println("finish");
        }
        System.out.println("MAIN END");
    }
}
