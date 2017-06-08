package com.greensnow25;


import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.io.File;

/**
 * public class CacheTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 08.06.2017.
 */
public class CacheTest {
    /**
     * class object.
     */
    private Cache<String, File> cache;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.cache = new Cache<>();
}

    /**
     * When the method is called once, it loads into the cache and reads from it.
     */
    @Test
    public void whenCallOnceThenSizeEqualsOne() {
        cache.sourceToUploadTheFile("D:\\javaaz\\javaaz\\chapter6\\demonstration\\src\\main\\java\\com\\greensnow25\\Names.txt");
     assertThat(cache.getMap().size(), is(1));
    }

    /**
     * Call the method twice the value of the map is equal to one.
     */
    @Test
    public void whenCallTwiceThenSizeEqualsOne() {
        cache.sourceToUploadTheFile("D:\\javaaz\\javaaz\\chapter6\\demonstration\\src\\main\\java\\com\\greensnow25\\Names.txt");
        cache.sourceToUploadTheFile("D:\\javaaz\\javaaz\\chapter6\\demonstration\\src\\main\\java\\com\\greensnow25\\Names.txt");
        assertThat(cache.getMap().size(), is(1));
    }


}