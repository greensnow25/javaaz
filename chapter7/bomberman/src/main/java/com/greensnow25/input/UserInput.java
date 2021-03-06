package com.greensnow25.input;

import com.greensnow25.board.Cell;

import java.util.List;
import java.util.Scanner;

/**
 * Public class Input.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class UserInput implements Input {
    /**
     * object of class scanner, use for reading from the keyboard.
     */
    private final Scanner sc;

    /**
     * constructor.
     */
    public UserInput() {
        sc = new Scanner(System.in);
    }

    /**
     * method displays question and read answer from the keyboard.
     *
     * @param question question.
     * @return answer.
     */
    @Override
    public Cell makeAStep(String question, List<Cell> list) {
        String sep = System.getProperty("line.separator");
        System.out.printf("%s%s%s%s", question, sep, "Enter axis X;", sep);
        int x = Integer.parseInt(sc.next());
        System.out.println("Enter axis Y;");
        int y = Integer.parseInt(sc.next());
        return new Cell(x, y);
    }
}
