package com.greensnow25.tracker.model;

/**
 * Public class InterfaceComment.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.08.2017.
 */
public interface InterfaceComment {
    /**
     * add comment.
     *
     * @param name     comment.
     * @param userName userName.
     * @return array of comments.
     */
    String[] addComment(String name, String userName);

    /**
     * show all user comments.
     *
     * @param userName name.
     * @return array of comments.
     */
    String[] show(String userName);
}
