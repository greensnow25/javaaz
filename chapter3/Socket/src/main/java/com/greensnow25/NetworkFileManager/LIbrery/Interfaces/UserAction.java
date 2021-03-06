package com.greensnow25.NetworkFileManager.LIbrery.Interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by greensnow25 on 13.03.2017.
 */
public interface UserAction {
    /**
     * key.
     *
     * @return key.
     */
    String key();

    /**
     * info.
     *
     * @return info.
     */
    String info();

    /**
     * what can we do.
     */
    void makeAction() throws IOException;


}
