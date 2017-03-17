package com.greensnow25.searchWithEnum.Librery;

import java.io.File;
import java.io.PrintWriter;

/**
 * public interface Find.
 *
 * @author greensnow25.
 * @version 1.
 * @since 17.03.2017.
 */
public interface Find {
    /**
     * searh.
     * @param fileWriter write.
     * @param file file.
     * @param line regExp.
     */
    void search(PrintWriter fileWriter, File file, String line);
}
