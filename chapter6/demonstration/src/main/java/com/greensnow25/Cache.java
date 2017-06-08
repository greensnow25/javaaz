package com.greensnow25;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * public class Cache.
 *
 * @author greensnow25.
 * @version 1.
 * @since 08.06.2017.
 */
public class Cache<K extends String, V extends File> extends ACache<String, V> {
    /**
     * SoftHashMap.
     */
    private HashMap<K, SoftReference<V>> map;

    /**
     * constructor.
     */
    public Cache() {

        this.map = new HashMap<>();
    }

    /**
     * The method checks if the file is in the cache, if there is no load and does not read.
     * @param path file path.
     */
    public void sourceToUploadTheFile(K path) {
        if (this.map.containsKey(path)) {
            this.readFromCache(path);
            return;
        } else this.uploadTheFileToCache(path);
        this.readFromCache(path);
    }

    /**
     * read from cache.
     * @param path file path.
     */
    @Override
    public void readFromCache(String path) {

        try {
            BufferedReader bt = new BufferedReader(new FileReader(path));
            String tmp;
            while ((tmp = bt.readLine()) != null) {
                System.out.println(tmp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * upload file to cache.
     * @param path file path.
     */
    @Override
    public void uploadTheFileToCache(String path) {
        File file = new File(path);
        map.put((K) path, new SoftReference<V>((V) file));
    }

    /**
     * getMap.
     * @return map.
     */
    public HashMap<K, SoftReference<V>> getMap() {
        return map;
    }

}
