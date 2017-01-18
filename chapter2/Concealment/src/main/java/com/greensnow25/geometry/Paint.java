package com.greensnow25.geometry;

/**
 * public class Paint used Patterns Stratege.
 * @author greensnow25.
 * @since 18.01.17.
 * @version 2.
 */
public class Paint {
    /**
     * fields classified.
     */
    private Shape shape;


    /**
     * constructor of the class.
     */
    public Paint() {

    }

    /**
     * return string.
     * @param shape some figure.
     * @return sting.
     */
    public String draw(Shape shape) {

        return shape.pic(shape);
    }
}
