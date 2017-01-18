package com.greensnow25.geometry;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * public ClassTest SqureTest.
 * @author greensnow25.
 * @since 18.01.17.
 * @version 2.
 */
public class SquareTest {
    /**
     * test method pic.
     */
    @Test
    public void whenRubThenReturnSquare() {
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