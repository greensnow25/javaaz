package com.greensnow25.geometry;

/**
 * public class Squre build squre from sibple symbols.
 * @author greensnow25.
 * @since 18/01/17.
 * @version 2.
 */
public class Square implements Shape {
    /**
     * height.
     */
   private int height;

    /**
     * class constructor.
     * @param height square.
     */

    public Square(int height) {
        this.height = height;
    }
    /**
     * Override method.
     * @return string.
     */
    @Override
    public String pic(Shape shape) {
        StringBuilder sb = new StringBuilder();
        int width = height * 2;
        int start = 1;
        for (int i = start; i <= height; i++) {
            for (int j = start; j <= width; j++) {
                if (i == start && j % 2 == 0 || j == width
                        || j == start + 1  || i == height && j % 2 == 0) {
                    sb.append("^");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }

}
