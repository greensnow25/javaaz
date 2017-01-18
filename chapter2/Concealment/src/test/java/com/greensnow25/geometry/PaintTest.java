package com.greensnow25.geometry;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * public ClassTest.
 * @author greensnow25.
 * @since 18.01.17.
 * @version 1.
 */
public class PaintTest {

    /**
     *  test return triangle.
     */
    @Test
    public void whenTriangleShapeThenReturnTriangle() {
        Paint paint = new Paint(new Triangle());
        String result = paint.draw();
        assertThat(result, is("    ^    \r\n"
                            + "   ^ ^   \r\n"
                            + "  ^   ^  \r\n"
                            + " ^     ^ \r\n"
                            + "^ ^ ^ ^ ^\r\n"));
    }

    /**
     * test return square.
     */
    @Test
    public void  whenSquareShapeThenReturnSquare() {
        Paint paint = new Paint(new Square());
        String result = paint.draw();
        assertThat(result, is(" ^ ^ ^ ^ ^\r\n"
                            + " ^       ^\r\n"
                            + " ^       ^\r\n"
                            + " ^       ^\r\n"
                            + " ^ ^ ^ ^ ^\r\n"));
    }

    /**
     * main test.
     */
    @Test
    public void whenRunAplicationThenReturnFigures()  {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint.main(null);
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