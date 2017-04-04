package com.greensnow25;

import java.util.*;

/**
 * public class Test.
 *
 * @author greensnow25.
 * @version 1.
 * @since 03.04.2017.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.runAndPrint();

    }

    /**
     * count of iterations.
     */
    private final int ITERATIONS = 10000;


    public void runAndPrint() {
        ArrayList<String> array = new ArrayList<>();
        LinkedList<String> link = new LinkedList<>();
        TreeSet<String> tree = new TreeSet<String>();
        Collection[] lists = new Collection[3];
        lists[0] = array;
        lists[1] = link;
        lists[2] = (Collection) tree;

        for (Collection list : lists) {

            System.out.printf("Time of addition %s is %f%s ", list.getClass(), testAdd(list), System.getProperty("line.separator"));
        }
        for (Collection list : lists) {

            System.out.printf("Removal time %s is %f%s ", list.getClass(), testRemove(list), System.getProperty("line.separator"));
        }
    }


    /**
     * add to list.
     *
     * @param list type of list.
     * @return time value.
     */
    public double testAdd(Collection<String> list) {
        long timeBefore = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {

            list.add(this.generateString());
        }
        return System.currentTimeMillis() - timeBefore;
    }

    /**
     * remove list;
     *
     * @param list list.
     * @return time value.
     */
    public double testRemove(Collection<String> list) {
        this.testAdd(list);
        long timeBefore = System.currentTimeMillis();
        for (int i = list.size(); i > 0; i--) {
            if(list instanceof TreeSet){
                list.clear();

            }
            list.remove(0);
        }
        return System.currentTimeMillis() - timeBefore;
    }

    /**
     * generate string.
     *
     * @return string.
     */
    public String generateString() {
        String symbols = "abcdefg";
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * 30);
        for (int i = 0; i < count; i++)
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));

        return randString.toString();

    }


}
