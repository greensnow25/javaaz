package com.greensnow25.patternProducerCostumer;

/**
 * Public class PatternProducerCostumer.
 *
 * @author greensnow25.
 * @version 1.
 * @since 07.07.2017.
 */
public class PatternProducerCostumer {
    /**
     * class object.
     */
    private MyBlockigQueue<Integer> work;
    /**
     * Flag indicating that all jobs have been added to the queue.
     */
    private volatile boolean loadFactor = false;

    /**
     * constructor.
     */
    public PatternProducerCostumer() {
        this.work = new MyBlockigQueue();
    }

    /**
     * run application.
     */
    public void run() {
        new Costumer().costume();
        new Producer().produce();
    }

    /**
     * main.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        PatternProducerCostumer pat = new PatternProducerCostumer();
        pat.run();
    }

    /**
     * inner class Producer.
     * Performs tasks and puts them in the queue.
     */
    private class Producer {
        /**
         * Performs tasks and puts them in the queue.
         */
        public void produce() {
            new Thread(() -> {
                for (int i = 0; i != 100; i++) {
                    try {
                        work.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                loadFactor = true;
            }).start();
        }
    }

    /**
     * Inner class Costumer.
     * Retrieves jobs from the queue and executes them.
     */
    private class Costumer {
        /**
         * Retrieves jobs from the queue and executes them.
         */
        public void costume() {
            new Thread(() -> {
                try {
                    while (!loadFactor) {
                        work.get();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}


