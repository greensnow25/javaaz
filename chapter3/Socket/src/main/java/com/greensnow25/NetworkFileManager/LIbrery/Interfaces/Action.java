package com.greensnow25.NetworkFileManager.LIbrery.Interfaces;

import java.io.IOException;

/**
 * Created by greensnow25 on 13.03.2017.
 */
public abstract class Action implements UserAction {
    /**
     * key.
     */
    private String key;
    /**
     * information, what can we do.
     */
    private String info;

    /**
     * key of action.
     * @return key.
     */
    public String key() {
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
    public Action(String key, String info) {
        this.key = key;
        this.info = info;
    }

    /**
     * make actions.
     */
    public abstract void makeAction() throws IOException;


}
