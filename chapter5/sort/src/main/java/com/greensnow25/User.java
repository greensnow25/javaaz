package com.greensnow25;

/**
 * public class User.
 *
 * @author greensnow25.
 * @version 1.
 * @since 05.04.2017.
 */
public class User implements Comparable<User> {
    /**
     * name.
     */
    private String name;
    /**
     * age.
     */
    private int age;

    /**
     * class constructor.
     *
     * @param age
     * @param name
     */
    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }


    @Override
    public int compareTo(User o) {

        return this.age > o.age ? 1 : this.age < o.age ? -1 : 0;
    }

    /**
     * getName.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * getAge.
     *
     * @return age.
     */
    public int getAge() {
        return age;
    }
}
