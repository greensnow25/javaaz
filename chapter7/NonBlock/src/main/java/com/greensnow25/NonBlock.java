package com.greensnow25;

/**
 * Public class NonBlock.
 *
 * @author greensnow25.
 * @version 1.
 * @since 14.07.2017.
 */
public class NonBlock {
    public class User {
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }


    public int compare(User left, User right) {

        return left.getName().compareTo(right.getName()) == 1 ? 1 : 0 ;
    }

}
