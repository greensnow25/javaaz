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
    /**
     * class object, using for correct work threads.
     */
    private Lock lock;
    /**
     * field for game.
     */
    private final Cell[][] board;
    /**
     * size of the playing field.
     */
    private final int size;
    /**
     * flag of boar creating.
     */
    private boolean bordCreate = false;
    /**
     * monster storage.
     */
    private Cell[] monstersStorage;
    /**
     * counter for adding to the monsterStorage.
     */
    private int count = 0;
    /**
     * class object player.
     */
    private Cell player;

    /**
     * constructor.
     *
     * @param size          size of playing field.
     * @param countMonsters count of monsters.
     */
    public Board(int size, int countMonsters) {
        this.size = size;
        this.lock = new ReentrantLock(true);
        monstersStorage = new Cell[countMonsters];
        this.board = new Cell[size][size];
    }

    /**
     * method automatically moves the monster.
     *
     * @param monsterPosition position.
     * @throws InterruptedException ex.
     */
    public void makeAMove(Cell monsterPosition) throws InterruptedException {
        int count = 0;
        lock.lock();
        Cell[] possibleMoves = monsterPosition.getEntity().move(monsterPosition);
        Cell[] cells = new Cell[possibleMoves.length];
        for (Cell i : possibleMoves) {
            if (this.checkOutTheBoard(i) && this.checkValidateMoves(i)) {
                cells[count++] = i;
            }
        }
        System.arraycopy(cells, 0, cells, 0, count);
        Monster monster = (Monster) monsterPosition.getEntity();
        Cell newCellMonsterPosition = cells[(int) (Math.random() * count - 1)];
        board[monsterPosition.getAxisX()][monsterPosition.getAxisY()].setEntity(null);
        for (int i = 0; i != monstersStorage.length; i++) {
            if (monstersStorage[i].equals(monsterPosition)) {
                monstersStorage[i] = newCellMonsterPosition;
                monstersStorage[i].setEntity(monster);
                break;
            }
        }
        board[newCellMonsterPosition.getAxisX()][newCellMonsterPosition.getAxisY()].setEntity(monster);
        lock.unlock();
    }

    /**
     * The method checks whether it is worth it in the way of the barrier.
     *
     * @param possibleMoves move.
     * @return result.
     */
    private boolean checkValidateMoves(Cell possibleMoves) {
        boolean res = false;
        try {
            if (board[possibleMoves.getAxisX()][possibleMoves.getAxisY()].getEntity() == null) {
                res = true;
            } else if (board[possibleMoves.getAxisX()][possibleMoves.getAxisY()].getEntity() instanceof Player) {
                res = true;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //NON*?
        } finally {
            return res;
        }
    }

    /**
     * method check does the entity go beyond the field.
     *
     * @param possibleMoves position.
     * @return result.
     */
    private boolean checkOutTheBoard(Cell possibleMoves) {
        boolean res = true;
        if (possibleMoves.getAxisX() > this.size || possibleMoves.getAxisY() > this.size
                || possibleMoves.getAxisX() < 0 || possibleMoves.getAxisY() < 0) {
            res = false;
        }
        return res;
    }

    /**
     * print playing field.
     */
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
                    } else if (board[i][j].getEntity() instanceof Monster) {
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

    /**
     * method generate once entity.
     *
     * @param entity for game.
     * @return position.
     */
    private Cell generateEntity(Entity entity) {
        while (true) {
            int x = this.generateRandomNumber();
            int y = this.generateRandomNumber();
            if (board[x][y].getEntity() == null) {
                board[x][y].setEntity(entity);
                if (entity instanceof Monster) {
                    monstersStorage[count++] = board[x][y];
                }
                return board[x][y];
            }
        }
    }

    /**
     * method generate random number from the specified range.
     *
     * @return random number.
     */
    private int generateRandomNumber() {
        return (int) (Math.random() * this.size-1);
    }

    /**
     * method create all entity on the playing field.
     */
    private void generateEntitys() {
        int count = 0;
        while (count != monstersStorage.length) {
            Monster monster = new Monster(String.valueOf(count));
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

    /**
     * prepare field for game.
     */
    public void runBoard() {
        createAndPrintBoard();
        generateEntitys();
        createAndPrintBoard();
    }

    public Cell[] getMonstersStorage() {
        return monstersStorage;
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

    public void setPlayer(Cell player) {
        this.player = player;
    }
}
