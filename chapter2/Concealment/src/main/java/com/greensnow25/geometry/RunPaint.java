package com.greensnow25.geometry;

/**
 * public class RunPaint.
 * @author greensnow25.
 * @since 18/01/17.
 * @version 2.7.
 */
public class RunPaint {
    /**
     * main.
     * @param args string.
     */
    public static void main(String[] args) {

        Shape tr = new Triangle(5);
        Shape sq = new Square(5);

        Paint paint = new Paint();

        System.out.println(paint.draw(tr));
        System.out.println(paint.draw(sq));

    }
}
