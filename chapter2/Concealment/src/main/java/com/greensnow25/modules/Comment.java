package com.greensnow25.modules;

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
     */

    public void  addComent(String name) {

          comments[position++] = name;
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
