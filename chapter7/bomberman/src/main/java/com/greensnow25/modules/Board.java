package com.greensnow25.modules;

import com.greensnow25.entity.Entity;

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

    public Board(int size, int countMonsters) {
        this.size = size;
        this.monsterCount = countMonsters;
        this.board = new Cell[size][size];
    }

    public void generateBarriers() {
        for (int i = 0; i != board.length; i++) {
            for (int j = 0; j != board[i].length; j++) {

            }
        }
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
    private void generateBoard(){

    }


    public static void main(String[] args) {
        Board d = new Board(3, 4);

    }
}
