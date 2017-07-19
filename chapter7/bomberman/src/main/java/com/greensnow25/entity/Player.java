package com.greensnow25.entity;

import com.greensnow25.Input;
import com.greensnow25.modules.Cell;

import java.util.Scanner;

/**
 * Public class Player.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class Player extends Entity {
    private Input input;

    public Player() {
        this.input = new Input();
    }

    @Override
    public Cell[] move(Cell currentPosition) {
        int x = Integer.parseInt(input.answer("Enter axis X:  "));
        int y = Integer.parseInt(input.answer("Enter axis Y:  "));
        return new Cell[]{new Cell(x, y)};
    }
}
