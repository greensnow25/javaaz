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

    private String[] comments2 = new String[10];

    /**
     * private field position in array.
     */

    private int position = 0;

    /**
     * connstructor of class.
     */
    public Comment(String comment) {
        this.comments2 = new String[10];
        comments2[position++] = comment;
    }
    public Comment() {
        this.comments2 = new String[10];
    }

    /**
     * public method add comment.
     * @param name name of new comment.
     */

    public String  addComent(String name) {

         return comments2[position++] = name;
    }

    /**
     * show all comments.
     * @return  result array.
     */
    public String[] show() {

        String[] result = new String[this.position];
        for (int index = 0; index != this.position; index++) {
            if (this.comments2[index] != null) {
               result[index] = this.comments2[index];
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * getComment.
     * @return coment.
     */
    public String[] getComment() {
        return comments2;
    }


}
