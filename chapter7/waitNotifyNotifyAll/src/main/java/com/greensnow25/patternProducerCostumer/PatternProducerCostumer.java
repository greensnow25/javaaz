package com.greensnow25.patternProducerCostumer;

/**
 * Public class PatternProducerCostumer.
 *
 * @author greensnow25.
 * @version 1.
 * @since 07.07.2017.
 */
public class PatternProducerCostumer {
    private UsefulWork work;
    private boolean loadFactor = false;

    public PatternProducerCostumer() {
        this.work = new UsefulWork();
    }

    public void run() {
        Producer pr = new Producer();
        Costumer cos = new Costumer();
        pr.produce();
        cos.costume();
    }

    public static void main(String[] args) {
        PatternProducerCostumer pat = new PatternProducerCostumer();
        pat.run();
    }


    private class Producer {

        public void produce() {
            Thread producer = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i != 100; i++) {
                        try {
                            work.put(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    loadFactor = true;

                }
            };
            producer.start();
        }
    }

    private class Costumer {
        public void costume() {
            Thread costume = new Thread() {
                @Override
                public void run() {
                    try {
                        while (!loadFactor) {
                            work.get();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            costume.start();
        }

    }


}


