package com.greensnow25.model;

/**
 * Public class Article.
 *
 * @author greensnow25.
 * @version 1.
 * @since 21.08.2017.
 */
public class Article {
    /**
     * name of article.
     */
    private String name;
    /**
     * URL of article.
     */
    private String URL;

    /**
     * constructor.
     *
     * @param name of article.
     * @param URL  of article.
     */
    public Article(String name, String URL) {
        this.name = name;
        this.URL = URL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
