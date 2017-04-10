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

        return Integer.compare(this.getAge(), o.getAge());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
