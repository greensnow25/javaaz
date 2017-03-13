package com.greensnow25.NetworkFileManager.LIbrery.Interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by greensnow25 on 13.03.2017.
 */
public abstract class Action implements UserAction {
    /**
     * key.
     */
    private int key;
    /**
     * information, what can we do.
     */
    private String info;

    /**
     * key of action.
     * @return key.
     */
    public int key() {
        return this.key;
    }

    /**
     * what can we do.
     * @return info.
     */
    public String info() {
        return String.format("%s. %s",this.key, this.info);
    }

    /**
     * constructor.
     * @param key key.
     * @param info info.
     */
    public Action(int key, String info) {
        this.key = key;
        this.info = info;
    }

    /**
     * mace actions.
     * @param in inputStream.
     * @param out outputStream.
     * @param rootDir root directory.
     */
    public abstract void makeAction(InputStream in, OutputStream out, String rootDir);

}
