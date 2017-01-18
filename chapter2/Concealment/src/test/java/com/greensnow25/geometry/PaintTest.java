package com.greensnow25.geometry;

import org.junit.Test;

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
        Shape shape = new Triangle(5);
        Paint paint = new Paint();
        String result = paint.draw(shape);
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
        Shape shape = new Square(5);
        Paint paint = new Paint();
        String result = paint.draw(shape);
        assertThat(result, is(" ^ ^ ^ ^ ^\r\n"
                            + " ^       ^\r\n"
                            + " ^       ^\r\n"
                            + " ^       ^\r\n"
                            + " ^ ^ ^ ^ ^\r\n"));
    }


}