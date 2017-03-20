package com.greensnow25.Librery;


import java.io.File;
import java.io.FileWriter;

/**
 * Interface Find.
 * @author greensnow25.
 * @since 16.03.17.
 * @version 1.
 */
public interface Find {
    /**
     * find file by... and write result on file.
     * @param fileWriter write to file.
     * @param file result file.
     * @param line line to search.
     * @param root dir to search.
     */
    void makeAction(FileWriter fileWriter, File file, String line, String root);
}
