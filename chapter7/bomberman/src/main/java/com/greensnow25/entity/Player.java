package com.greensnow25.entity;

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
    private Scanner sc = new Scanner(System.in);
    @Override
    public Cell[] move() {
        System.out.println("Enter axis X:  ");
        int x =Integer.parseInt(sc.next());
        System.out.println("Enter axis X:  ");
        int y =Integer.parseInt(sc.next());
        return new Cell[]{new Cell(x,y)};
    }
}
