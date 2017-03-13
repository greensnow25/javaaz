package com.greensnow25.NetworkFileManager.LIbrery.Interfaces;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by greensnow25 on 13.03.2017.
 */
public interface UserAction {
    /**
     * key.
      * @return key.
     */
    int key();

    /**
     * info.
     * @return info.
     */
    String info();

    /**
     * what can we do.
     * @param in inputStrean.
     * @param out outputStream.
     * @param rootDir dir.
     */
    void makeAction(InputStream in, OutputStream out, String rootDir);


}
