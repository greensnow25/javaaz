package com.greensnow25.fileSearch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Public class Search.
 *
 * @author greensnow25.
 * @version 1.
 * @since 04.07.2017.
 */
public class Search {
    /**
     * Paths repository.
     */
    private List<File> collect;
    /**
     * file name, which need to fifd.
     */
    private String name;
    /**
     * If true, then complete the program after first discovery request.
     */
    private boolean flag;
    /**
     * Flag stating that the first match was found.
     */
    private boolean firstFind;

    /**
     * Constructor.
     *
     * @param name      file name.
     * @param findFirst flag.
     */
    public Search(String name, Boolean findFirst) {
        this.collect = new ArrayList<>();
        this.name = name;
        this.flag = findFirst;
        this.firstFind = false;
    }

    /**
     * The class creates a separate stream for each disk and searches.
     * for all directories by adding them to the repository.
     */
    private class ProducePaths implements Runnable {
        /**
         * run.
         */
        @Override
        public void run() {
            for (File f : File.listRoots()) {
                Thread x = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        add(f);
                        collectPaths(f);
                        System.out.println("done" + f.getAbsolutePath());
                    }
                });
                x.setDaemon(true);
                x.start();
            }
        }

        public void collectPaths(File file) {
            if (file.listFiles() == null) return;
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    this.add(f);
                    this.collectPaths(f);
                }
            }
        }

        /**
         * sync. add.
         *
         * @param file added.
         */
        private void add(File file) {
            synchronized (collect) {
                collect.add(file);
            }
        }
    }

    /**
     * A class object retrieves an object from the repository.
     * performs a search in the specified location, by name.
     * If a file is found, the path to the search file.
     */
    private class Costumer implements Runnable {
        /**
         * run
         */
        @Override
        public void run() {
            File f = new File(collect.get(0).getAbsolutePath());
            findInThePath(f);
            this.remove(f);
        }

        /**
         * search file in the specified location.
         *
         * @param path to the file.
         */
        public void findInThePath(File path) {
            if (path.listFiles() == null) return;
            for (File f : path.listFiles()) {
                if (f.isFile() && f.getName().equals(name)) {
                    System.out.println(f.getAbsolutePath());
                    firstFind = true;
                    break;
                }
            }
        }

        /**
         * sync. remove.
         *
         * @param file to be deleted.
         */
        private void remove(File file) {
            synchronized (collect) {
                collect.remove(file);
            }
        }
    }

    /**
     * start the search.
     *
     * @throws InterruptedException ex.
     */
    public void startSearch() throws InterruptedException {
        boolean b = false;
        ExecutorService e = Executors.newFixedThreadPool(3);
        e.submit(new ProducePaths());
        Thread.sleep(100);
        while (collect.size() != 0 || b) {
            Thread.sleep(1);
            e.submit(new Costumer());
            if (flag && firstFind) {
                e.shutdownNow();
                break;
            }
        }
        e.shutdown();

    }


    public static void main(String[] args) throws InterruptedException {
        Search search = new Search("hellohellohello.txt", true);
        search.startSearch();

    }
}