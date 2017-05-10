package com.greensnow25.Primes;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class PrimesTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 10.05.2017.
 */
public class PrimesTest {
    /**
     * class object.
     */
    private Primes primes;
    /**
     * test array.
     */
    private int[] array;

    /**
     * run before the test.
     */
    @Before
    public void beforeTheTest() {
        this.array = new int[]{1, 2, 3, 4, 5, 13, 45, 34, 47, 79, 87, 55};
        this.primes = new Primes(this.array);
    }

    /**
     * test next call next twice, return 2.
     */
    @Test
    public void whenCallNextReturnPrimeNumber() {

        int res = (int) primes.next();

        assertThat(res, is(2));
    }

    /**
     * test next. call five times, return 47.
     */
    @Test
    public void whenCallNextFiveTimesThenReturnFortySeven() {
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res = (int) primes.next();
        }
        assertThat(res, is(47));
    }

    /**
     * test next. call 10 times, generate exception.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenCallNextTenTimesThenReturnException() {
        for (int i = 0; i < 10; i++) {
            primes.next();
        }
    }

    /**
     * test hasNext, when call , return true.
     */
    @Test
    public void whenCallHasNextThenReturnTrue() {
        for (int i = 0; i < 5; i++) {
            primes.next();
        }
        assertTrue(primes.hasNext());
    }

    /**
     * test hasNext. when no more primes in the array, then if we call hasNext return false.
     */
    @Test
    public void whenCallHasNextAndNoPrimesInArrayThenReturnFalse() {
        for (int i = 0; i < 6; i++) {
            primes.next();
        }
        assertFalse(primes.hasNext());
    }

}