package com.greensnow25;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * public classTest ZipProgrct arhive progect .
 *
 * @author grensnow25.
 * @version 1.
 * @since 06.03.17.
 */
public class ZipProjectTest {

    /**
     * test method.
     *
     * @throws Exception ex.
     */
    @Test
    public void whenMakeZipArhivetThenReturnNotNull() throws Exception {
        ZipProject zp = new ZipProject("D:\\chapter.zip", "D:\\temp", ".java");

        zp.makeZipArhive();
        File file = new File("D:\\chapter.zip");
        assertNotNull(file);
    }

}