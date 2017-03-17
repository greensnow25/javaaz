package com.greensnow25.searchWithEnum.Librery;

import java.io.File;
import java.io.PrintWriter;

/**
 * public class FindByMask.
 *
 * @author greensnow25.
 * @version 1.
 * @since 17.03.2017.
 */
public class FindByMask implements Find {
    @Override
    public void search(PrintWriter fileWriter, File file, String line) {
        if (file.getName().endsWith(line)) {
            fileWriter.println(file.getAbsolutePath());
        }

    }
}
