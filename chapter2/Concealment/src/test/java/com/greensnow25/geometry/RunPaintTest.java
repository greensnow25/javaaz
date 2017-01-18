package com.greensnow25.geometry;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * public class RunPaintTest.
 * @author greensnow25.
 * @since 18.01.17.
 * @version 2.
 */
public class RunPaintTest {
    /**
     * main test.
     */
    @Test
    public void whenRunAplicationThenReturnFigures()  {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        RunPaint.main(null);
        assertThat(out.toString(), is("    ^    \r\n"
                                    + "   ^ ^   \r\n"
                                    + "  ^   ^  \r\n"
                                    + " ^     ^ \r\n"
                                    + "^ ^ ^ ^ ^\r\n"
                                    +           "\r\n"
                                    + " ^ ^ ^ ^ ^\r\n"
                                    + " ^       ^\r\n"
                                    + " ^       ^\r\n"
                                    + " ^       ^\r\n"
                                    + " ^ ^ ^ ^ ^\r\n\r\n"));



    }


}