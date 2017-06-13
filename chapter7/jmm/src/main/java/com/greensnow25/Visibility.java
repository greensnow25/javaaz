package com.greensnow25;

/**
 * public class Visibility.
 *
 * @author greensnow25.
 * @version 1.
 * @since 13.06.2017.
 */
public class Visibility {
    private int count;

    public Visibility(int count) {
        this.count = count;
    }

    public void inc(){
        count++;
    }

    public void runThread(){
        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                inc();

            }
        });
        one.start();
        System.out.println(count);
    }

    public static void main(String[] args) {
        Visibility visibility = new Visibility(1);
        visibility.runThread();
        System.out.println(visibility.count);
    }
}
