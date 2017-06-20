package com.greensnow25;

/**
 * public class Visibility.
 *
 * @author greensnow25.
 * @version 1.
 * @since 13.06.2017.
 */
public class Visibility {
    /**
     * counter.
     */
    private int count = 0;
    /**
     * first thread.
     */
    private Thread two;
    /**
     * second thread.
     */
    private Thread one;

    /**
     * create new myThread.
     */
    private class MyThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i != 100_000_000; i++) {
                count++;
            }
        }
    }

    /**
     * run threads.
     */
    public void runThreads()  {
        this.one = new Thread(new MyThread());
        this.two = new Thread(new MyThread());

        one.start();
        two.start();


    }

    /**
     * main.
     * @param args args.
     */
    public static void main(String[] args)  {
        Visibility visibility = new Visibility();
        visibility.runThreads();
        while (visibility.one.isAlive() || visibility.two.isAlive()) ;

        System.out.println(visibility.count);
    }
}
