package com.greensnow25.modules;

import com.greensnow25.entity.*;

/**
 * Public class Board.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class Board {
    private final Cell[][] board;
    private final int size;
    private final int monsterCount;
    private boolean bordCreate = false;

    public Board(int size, int countMonsters) {
        this.size = size;
        this.monsterCount = countMonsters;
        this.board = new Cell[size][size];
    }

    public void createAndPrintBoard() {
        for (int i = 0; i != board.length; i++) {
            for (int j = 0; j != board[i].length; j++) {
                if (!this.bordCreate) {
                    board[i][j] = new Cell(i, j);
                } else {
                    if (board[i][j].getEntity() == null) {
                        System.out.print(" * ");
                    } else if (board[i][j].getEntity() instanceof Barrier) {
                        System.out.print(" B ");
                    } else if (board[i][j].getEntity() instanceof MyMonsterTwo) {
                        System.out.print(" M ");
                    } else {
                        System.out.print(" P ");
                    }
                }
            }
            System.out.print(System.getProperty("line.separator"));
        }
        this.bordCreate = true;
    }

    private void generateEntity(Entity entity) {
        while (true) {
            int x = this.generateRandomNumber();
            int y = this.generateRandomNumber();
            if (board[x][y].getEntity() == null) {
                board[x][y].setEntity(entity);
                break;
            }
        }
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * this.size);
    }

    private void generateEntityes() {
        int count = monsterCount;
        while (count != 0) {
            generateEntity(new MyMonsterTwo(String.valueOf(count)));
            count--;
        }
        int barriers = size;
        while (barriers != 0) {
            generateEntity(new Barrier());
            barriers--;
        }
        generateEntity(new Player());

    }


    public static void main(String[] args) {
        Board d = new Board(10, 4);
        d.createAndPrintBoard();
        d.generateEntityes();
        d.createAndPrintBoard();
    }
}
