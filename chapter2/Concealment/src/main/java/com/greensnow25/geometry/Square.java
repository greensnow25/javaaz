package com.greensnow25.geometry;

/**
 * public class Squre build squre from sibple symbols.
 * @author greensnow25.
 * @since 18/01/17.
 * @version 1.
 */
public class Square implements Shape {
    /**
     * Override method.
     * @return string.
     */
    @Override
    public String pic() {
        StringBuilder sb = new StringBuilder();
        int weght = 5;
        int height = weght * 2;
        int start = 1;
        for (int i = start; i <= weght; i++) {
            for (int j = start; j <= height; j++) {
                if (i == start && j % 2 == 0 || j == height
                        || j == start + 1  || i == weght && j % 2 == 0) {
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
