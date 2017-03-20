package com.greensnow25;

/**
 * public class Brackets.
 *
 * @author greensnow25.
 * @version 1.
 * @since 20.03.2017.
 */
public class Brackets {
    /**
     * main.
     * @param args param.
     */
    public static void main(String[] args) {
        Brackets brackets = new Brackets(args[0]);
        brackets.check();
    }

    /**
     * line of brackets.
     */
    private final String brackets;

    /**
     * class constructor.
     * @param brackets line.
     */
    public Brackets(String brackets) {
        this.brackets = brackets;
    }

    /**
     * Checks the correct closing of brackets.
     * @return true if correct.
     */
    public boolean check() {
        int count = 0;
        boolean res = false;

        for (char symbol : brackets.toCharArray()) {
            if (symbol == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return res;
            }
        }
        if (count == 0) {
            res = true;
        }

        return res;
    }
}
