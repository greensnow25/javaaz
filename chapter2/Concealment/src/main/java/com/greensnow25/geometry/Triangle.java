package com.greensnow25.geometry;

/**
 * public class Triangle build triangle.
 * @author greensnow25.
 * @since  19/01/17.
 * @version 2.
 */
public class Triangle implements Shape {
    /**
     * height.
     */
    private int height;

    /**
     * class constructor.
     * @param height of triangle.
     */
    public  Triangle(int height) {
        this.height = height;
    }

    @Override
    public String pic(Shape shape) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= height * 2 - 1; j++) {
                if (j == height - i + 1 || j == height + i - 1) {
                    sb.append("^");
                } else if (i == height && j % 2 != 0) {
                    sb.append("^");
                } else {
                    sb.append(" ");
                }
            } sb.append("\r\n");
        }
        return sb.toString();
    }

}
