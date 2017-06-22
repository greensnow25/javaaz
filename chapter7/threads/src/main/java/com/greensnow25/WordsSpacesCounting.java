package com.greensnow25;

import java.util.Iterator;
import java.util.List;
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
     * Method run threads.
     */
    public void runThreads() throws InterruptedException {
        this.service = Executors.newFixedThreadPool(3);
        service.submit(new CountSpaces());
        service.submit(new CountWords());
        service.submit(new Runnable() {
            /**
             * run infinite thread.
             */
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("INFINITE THREAD INTERRUPTED");
                    }
                }
            }
        });
        service.shutdown();
        service.awaitTermination(this.wait, TimeUnit.SECONDS);
        if (!service.isTerminated()) {
            service.shutdownNow();
        }
    }

    /**
     * Class counting words.
     */
    private class CountWords extends Thread {
        @Override
        public void run() {
            int count = 0;
            Pattern pattern = Pattern.compile("\\w*[^\\s*]");
            Matcher matcher = pattern.matcher(line);
            while (!Thread.currentThread().isInterrupted() && matcher.find()) {
                count++;
            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread words is interrupted.");
            }
            System.out.printf("%s %d%s", "Number of words", count, separator);
        }
    }

    /**
     * Class counting spaces.
     */
    protected class CountSpaces extends Thread {
        /**
         * run thread.
         */
        @Override
        public void run() {
            int count = 0;
            Pattern pattern = Pattern.compile("\\s");
            Matcher matcher = pattern.matcher(line);
            while (!Thread.currentThread().isInterrupted() && matcher.find()) {
                count++;
            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread spaces is interrupted.");
            }
            System.out.printf("%s %d%s", "Number of spaces", count, separator);
        }
    }

    /**
     * getExecutorServices.
     *
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
                if (word.getService().isTerminated()) {
                    break label;
                }
            }
            System.out.println("finish");
        }
        System.out.println("MAIN END");
    }

}
