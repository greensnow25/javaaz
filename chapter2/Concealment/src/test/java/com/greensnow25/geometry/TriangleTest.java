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

        String result = new Triangle().pic();
        assertThat(result, is("    ^    \r\n"
                            + "   ^ ^   \r\n"
                            + "  ^   ^  \r\n"
                            + " ^     ^ \r\n"
                            + "^ ^ ^ ^ ^\r\n"));
    }

}