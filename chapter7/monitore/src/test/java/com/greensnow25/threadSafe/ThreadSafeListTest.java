package com.greensnow25.threadSafe;

import jdk.nashorn.internal.runtime.regexp.joni.constants.TargetInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class ThreadSafeListTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 23.06.2017.
 */
public class ThreadSafeListTest {

    private ThreadSafeList<Integer> threadSafeList;

    private int count;

    @Before
    public void beforeTheTEst() {
        this.threadSafeList = new ThreadSafeList<>();
    }

    /**
     * We test the synchronization, if we start a cycle in two threads.
     * where we add up the same element, the result is the sum of two cycles.
     */
    @Test
    public void whenAddValuesThenResultIsSumOfCyclesThreads() throws InterruptedException {

        Thread one = this.createThread(10_000);
        Thread two = this.createThread(10_000);
        one.start();
        two.start();
        one.join();
        two.join();

        assertThat(threadSafeList.getArray().length, is(20_000));
    }

    private Thread createThread(int range) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i != range; i++) {
                    threadSafeList.add(i);
                }
            }
        });
    }


}