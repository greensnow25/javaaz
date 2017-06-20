package com.greensnow25;

/**
 * public class VisibilityProblemSolution.
 *
 * @author greensnow25.
 * @version 1.
 * @since 21.06.2017.
 */
public class VisibilityProblemSolution {
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
            for (int i = 0; i != 10_000_000; i++) {
                inc();
            }
        }
    }

    /**
     * increment.
     */
    public synchronized void inc (){
        count++;
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
        long start = System.currentTimeMillis();
        VisibilityProblemSolution visibility = new VisibilityProblemSolution();
        visibility.runThreads();
        while (visibility.one.isAlive() || visibility.two.isAlive()) ;

        System.out.println(visibility.count);
        System.out.println((System.currentTimeMillis() - start)/100);
    }
}
