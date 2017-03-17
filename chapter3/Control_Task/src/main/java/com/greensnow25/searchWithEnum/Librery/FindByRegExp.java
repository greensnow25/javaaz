package com.greensnow25.searchWithEnum.Librery;

import java.io.File;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * public class FindByRegExp.
 *
 * @author greensnow25.
 * @since 17.03.2017.
 * @version 1.
 */
public class FindByRegExp implements Find {
    @Override
    public void search(PrintWriter fileWriter, File file, String regExp) {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(file.getName());
        boolean write;
        write = matcher.find();
        if (write) {
            fileWriter.println(file.getAbsolutePath());
        }
    }
}