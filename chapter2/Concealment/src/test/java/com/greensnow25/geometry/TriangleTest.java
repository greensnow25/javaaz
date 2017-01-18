package com.greensnow25.geometry;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * public ClassTest TriangleTest.
 * @author greensnow25.
 * @since 18.01.17.
 * @version 1.
 */
public class TriangleTest {
    /**
     * test return triangle.
     */
    @Test
    public void whenRubThenReturnTriangle() {
        Shape tr = new Triangle(5);
        String result = new Triangle(5).pic(tr);
        assertThat(result, is("    ^    \r\n"
                            + "   ^ ^   \r\n"
                            + "  ^   ^  \r\n"
                            + " ^     ^ \r\n"
                            + "^ ^ ^ ^ ^\r\n"));
    }

}