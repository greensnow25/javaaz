package com.greensnow25.geometry;

/**
 * public class Paint used Patterns Stratege.
 * @author greensnow25.
 * @since 18.01.17.
 * @version 1.
 */
public class Paint {
    /**
     * fields classified.
     */
    private Shape shape;

    /**
     * constructor of the class.
     * @param shape any shape.
     */
    public Paint(Shape shape) {
        this.shape = shape;
    }

    /**
     * public method draw the shape.
     * @return draw shape.
     */
    public String draw() {

        return shape.pic();
    }

    /**
     * main.
     * @param args string.
     */
    public static void main(String[] args) {
       Paint paint = new Paint(new Triangle());
        System.out.println(paint.draw());

         paint = new Paint(new Square());
        System.out.println(paint.draw());

    }
}
