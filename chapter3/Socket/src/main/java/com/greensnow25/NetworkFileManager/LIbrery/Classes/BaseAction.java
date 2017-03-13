package com.greensnow25.NetworkFileManager.LIbrery.Classes;

import com.greensnow25.NetworkFileManager.LIbrery.Interfaces.Action;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by greensnow25 on 13.03.2017.
 */
public class BaseAction {
    /**
     * inputStream.
     */
    InputStream input;
    /**
     * outputStream.
     */
    OutputStream output;
    /**
     * root Directory.
     */
    String rootDir;
    
    public BaseAction(InputStream input, OutputStream output, String rootDir){
        this.input = input;
        this.output = output;
        this.rootDir = rootDir;
        
    }

    public class UpRootDirectory extends Action {

        /**
         * constructor.
         *
         * @param key  key.
         * @param info info.
         */
        public UpRootDirectory(int key, String info) {
            super(key, info);
        }

        @Override
        public void makeAction(InputStream in, OutputStream out, String rootDir) {

        }
    }
}
