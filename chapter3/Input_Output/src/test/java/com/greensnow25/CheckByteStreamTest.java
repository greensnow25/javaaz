package com.greensnow25;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * public class CheckByteStream check in that the recorded bit stream is an even number.
 *
 * @author grensnow25.
 * @version 1.
 * @since 13.02.17.
 */
public class CheckByteStreamTest {
    /**
     * method test, when number is even.
     *
     * @throws IOException exeption.
     */
    @Test
    public void whenNumerIsEvenThenReturnTrue() throws IOException {
        CheckByteStream ch = new CheckByteStream();
        String test = "2";
        try (ByteArrayInputStream ba = new ByteArrayInputStream(test.getBytes())) {

            assertThat(ch.isNumber(ba), is(true));
        }
    }

    /**
     * method test, when number is odd.
     *
     * @throws IOException exeptions.
     */
    @Test
    public void whenNumerIsOddThenReturnFalse() throws IOException {
        CheckByteStream ch = new CheckByteStream();
        String test = "3";
        try (ByteArrayInputStream ba = new ByteArrayInputStream(test.getBytes())) {

            assertThat(ch.isNumber(ba), is(false));
        }
    }
}



