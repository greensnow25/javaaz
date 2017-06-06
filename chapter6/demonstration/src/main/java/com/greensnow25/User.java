package com.greensnow25;

/**
 * public class User.
 *
 * @author greensnow25.
 * @version 1.
 * @since 07.06.2017.
 */
public class User {
    /**
     * name.
     */
    private String name;
    /**
     * age.
     */
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("garbage run");
    }

    public void info() {
        int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        System.out.println("total memory " + (runtime.totalMemory()) / mb);
        System.out.println("used memory " + (runtime.totalMemory() - runtime.freeMemory()) / mb);
        System.out.println("free memory " + runtime.freeMemory() / mb);
    }

    public static void main(String[] args) {
        new User().info();
        for (int i = 0; i != 5000; i++) {
            new User("Mike", i);
        }
        new User().info();
    }
}