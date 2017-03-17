package com.greensnow25.searchWithEnum;

import com.greensnow25.searchWithEnum.Librery.Find;
import com.greensnow25.searchWithEnum.Librery.FindByMask;
import com.greensnow25.searchWithEnum.Librery.FindByName;
import com.greensnow25.searchWithEnum.Librery.FindByRegExp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * public class FileSearch.
 *
 * @author greensnow25.
 * @version 1.
 * @since 17.03.2017.
 */
public class FileSearch {

    /**
     * In this application it does not matter.
     */
    private String startKey;
    /**
     * directory for search.
     */
    private String searchDir;
    /**
     * search type.
     */
    private String kindSearch;
    /**
     * Search expression.
     */
    private String regExp;
    /**
     * In this application it does not matter.
     */
    private String saveKey;
    /**
     * The path for the file in which we store the result.
     */
    private String saveDir;
    /**
     * array contain search methods.
     */
    private Find[] findBy = new Find[3];

    /**
     * class constructor.
     * @param starteKey In this application it does not matter.
     * @param searchDir directory for search.
     * @param kindSearch search type.
     * @param regExp Search expression.
     * @param saveKey In this application it does not matter.
     * @param saveDir The path for the file in which we store the result.
     */
    public FileSearch(String starteKey, String searchDir, String kindSearch, String regExp, String saveKey, String saveDir) {
        this.startKey = starteKey;
        this.searchDir = searchDir;
        this.kindSearch = kindSearch;
        this.regExp = regExp;
        this.saveKey = saveKey;
        this.saveDir = saveDir;
    }

    /**
     * filling array.
     */
    private void filleng() {
        int position = 0;
        this.findBy[position++] = new FindByName();
        this.findBy[position++] = new FindByMask();
        this.findBy[position++] = new FindByRegExp();
    }

    /**
     * parse directory.
     * @param find find method.
     * @param fileWriter write in the file.
     * @param fileDir current directory.
     * @param regExp pattern for search.
     */
    private void parse(Find find, PrintWriter fileWriter, File fileDir, String regExp) {

        for (File files : fileDir.listFiles()) {
            if (files.isFile()) {
                find.search(fileWriter, files, regExp);
            } else if (files.isDirectory()) {
                this.parse(find, fileWriter, files, regExp);
            }
        }
    }

    /**
     * run application.
     */
    private void fileSearch() {
        this.filleng();
        File saveFile = new File(this.saveDir);
        File searchDir = new File(this.searchDir);
        try (PrintWriter fileWriter = new PrintWriter(saveFile);) {
            Find searchBy = searchMethot();
            parse(searchBy, fileWriter, searchDir, regExp);
            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * find method by mask.
     * @return method of searh.
     */
    private Find searchMethot() {
        Find fi = null;
        for (Search names : Search.values()) {
            if (names.key.equals(this.kindSearch)) {
                fi = findBy[names.ordinal()]; //search(fileWriter,searchDir,this.regExp);

            }
        }
        return fi;
    }

    /**
     * enum search metods.
     */
    private enum Search {
        /**
         * We use the constant to search by name.
         */
        NAME("-n"),
        /**
         * We use the constant to search by mask.
         */
        MASK("-m"),
        /**
         * We use the constant to search by regular expression.
         */
        REGEX("-r");
        /**
         * key.
         */
        private String key;

        /**
         * constructor.
         * @param key key.
         */
        Search(String key) {
            this.key = key;
        }

    }


}
