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
    private String[] comments = new String[10];


    private int position = 0;

    public Comment(String[] comments) {
        this.comments = comments;

    }

    public Comment() {

    }

    public String  addComent(String name) {

        return comments[position++] = name;
    }

    public void show() {
        for(String s : this.comments) {
            System.out.println(s);
        }
    }

    /**
     * getComment.
     * @return coment.
     */
    public String[] getComment() {
        return comments;
    }

    /**
     * setComment.
     * @param comment this.coment.
     */
    public void setComment(String[] comment) {
        this.comments = comment;
    }



}
