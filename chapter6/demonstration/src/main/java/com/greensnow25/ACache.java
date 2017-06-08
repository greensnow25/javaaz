package com.greensnow25;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

/**
 * public class Ceshe.
 *
 * @author greensnow25.
 * @version 1.
 * @since 08.06.2017.
 */
public abstract class ACache<K, V> {

    /**
     * upload file to cache.
     *
     * @param path file path.
     */
    public abstract void uploadTheFileToCache(K path);

    /**
     * read from cache.
     *
     * @param path file path.
     */

    public abstract void readFromCache(K path);

}
