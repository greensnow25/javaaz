package com.greensnow25.searchWithEnum.Librery;

import java.io.File;
import java.io.PrintWriter;

/**
 * public class FindByName.
 *
 * @author greensnow25.
 * @version 1.
 * @since 17.03.2017.
 */
public class FindByName implements Find {

    @Override
    public void search(PrintWriter fileWriter, File file, String line) {
        StringBuilder sb = new StringBuilder(line);
        boolean write = file.getName().contains(sb);
        if (write) {
            fileWriter.println(file.getAbsolutePath());
        }
    }
}
