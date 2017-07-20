package com.greensnow25.modules;

import com.greensnow25.entity.*;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Public class Board.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class Board {
    private final CyclicBarrier BARRIER;
    private Lock lock;
    private final Cell[][] board;
    private final int size;
    private boolean bordCreate = false;
    private Cell[] monstersStorage;
    private int count = 0;
    private Cell player;

    public Board(int size, int countMonsters) {
        this.size = size;
        this.BARRIER = new CyclicBarrier(countMonsters + 50);
        this.lock = new ReentrantLock(true);
        monstersStorage = new Cell[countMonsters];
        this.board = new Cell[size][size];

    }

    public void makeAMove(Cell monsterPosition) throws BrokenBarrierException, InterruptedException {

        int count = 0;
        //  BARRIER.await();
        lock.lock();
        Cell[] possibleMoves = monsterPosition.getEntity().move(monsterPosition);
        Cell[] cells = new Cell[possibleMoves.length];
        for (Cell i : possibleMoves) {
            if (this.checkOutTheBoard(i) && this.checkValidateMoves(i)) {
                cells[count++] = i;
            }
        }
        System.arraycopy(cells, 0, cells, 0, count);
        MyMonsterTwo monster = (MyMonsterTwo) monsterPosition.getEntity();
        Cell newCellMonsterPosition = cells[(int) (Math.random() * cells.length)];
        for (int i = 0; i != monstersStorage.length; i++) {
            if (monstersStorage[i].equals(monsterPosition)) {
                monstersStorage[i] = newCellMonsterPosition;
                break;
            }
        }
        monsterPosition.setEntity(null);
        newCellMonsterPosition.setEntity(monster);

        lock.unlock();
    }

    private boolean checkValidateMoves(Cell possibleMoves) {
        boolean res = false;
        if (possibleMoves.getEntity() == null) {
            res = true;
        } else if (possibleMoves.getEntity() instanceof Player) {
            res = true;
        }
        return res;
    }

    private boolean checkOutTheBoard(Cell possibleMoves) {
        boolean res = true;
        if (possibleMoves.getAxisX() > this.size || possibleMoves.getAxisY() > this.size
                || possibleMoves.getAxisX() < 0 || possibleMoves.getAxisY() < 0) {
            res = false;
        }

        return res;
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
        System.out.print(System.getProperty("line.separator"));
        this.bordCreate = true;
    }

    private Cell generateEntity(Entity entity) {

        while (true) {
            int x = this.generateRandomNumber();
            int y = this.generateRandomNumber();
            if (board[x][y].getEntity() == null) {
                board[x][y].setEntity(entity);

                if (entity instanceof MyMonsterTwo) {
                    monstersStorage[count++] = board[x][y];
                }
                return board[x][y];
            }
        }
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * this.size);
    }

    private void generateEntitys() {
        int count = 0;
        while (count != monstersStorage.length) {
            MyMonsterTwo monster = new MyMonsterTwo(String.valueOf(count));
            generateEntity(monster);

            count++;

        }
        int barriers = size;
        while (barriers != 0) {
            generateEntity(new Barrier());
            barriers--;
        }
        this.player = generateEntity(new Player(this));

    }

    public Cell[] getMonstersStorage() {
        return monstersStorage;
    }

    public void runBoard() {
        createAndPrintBoard();
        generateEntitys();
        createAndPrintBoard();

    }

    public Cell getPlayer() {
        return player;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public Lock getLock() {
        return lock;
    }

    public static void main(String[] args) {
        Board d = new Board(10, 4);
        d.createAndPrintBoard();
        d.generateEntitys();
        d.createAndPrintBoard();


    }
}
