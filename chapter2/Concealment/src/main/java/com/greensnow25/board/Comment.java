package com.greensnow25.board;

/**
 * public class Comment create comment for Item.
 * @author greensnow25.
 * @since 19.01.17.
 * @version 1.
 */
public class Comment {

    /**
     * private field comment.
     */

    private String[] comments;

    /**
     * private field position in array.
     */

    private int position = 0;

    /**
     * connstructor of class.
     */
    public Comment() {
        this.comments = new String[10];

    }


    /**
     * public method add comment.
     * @param name name of new comment.
     * @return array of strings.
     */

    public String[] addComent(String name) {
        String[] result = name.split(System.getProperty("line.separator"));

        for (int i = 0; i < result.length; i++) {
            comments[position++] = result[i];
        }

        return comments;
    }

    /**
     * show all comments.
     * @return  result array.
     */
    public String[] show() {

        String[] result = new String[this.position];
        for (int index = 0; index != this.position; index++) {
            if (this.comments[index] != null) {
               result[index] = this.comments[index];
            } else {
                break;
            }
        }
        return result;
    }



}
