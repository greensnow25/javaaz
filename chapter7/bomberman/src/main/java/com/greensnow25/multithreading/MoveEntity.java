package com.greensnow25.multithreading;


import com.greensnow25.modules.Board;
import com.greensnow25.modules.Cell;

import java.util.concurrent.*;

/**
 * Public class MoveEntity.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class MoveEntity {
    /**
     * indicate of user input.
     */
    private volatile boolean next;
    /**
     * class object.
     */
    private final Board board;
    /**
     * Class object.
     */
    private ExecutorService ex;

    /**
     * constructor.
     *
     * @param size          size .
     * @param countMonsters count of monsters.
     */
    public MoveEntity(int size, int countMonsters) {
        this.ex = Executors.newFixedThreadPool(countMonsters + 1);
        this.board = new Board(size, countMonsters);
        this.next = false;
    }

    /**
     * create task.
     *
     * @param monster position.
     * @return task.
     */
    public Runnable createThreads(Cell monster) {
        return () -> {
            try {
                board.makeAMove(monster);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
    }

    /**
     * create thread pool.
     *
     * @throws InterruptedException
     */
    public void createPool() throws InterruptedException {

        while (true) {
            for (Cell monster : board.getMonstersStorage()) {
                ex.execute(createThreads(monster));
            }
            Thread.sleep(100);
            ex.execute(new Runnable() {
                @Override
                public void run() {
                    board.getPlayer().getEntity().move(board.getPlayer());
                    next = true;
                }
            });
            while (!next) Thread.sleep(10);
            board.createAndPrintBoard();
            next = false;
        }
    }

    /**
     * run.
     *
     * @throws InterruptedException ex.
     */
    public void run() throws InterruptedException {
        board.runBoard();
        createPool();
    }

    /**
     * main.
     *
     * @param args args.
     * @throws InterruptedException ex.
     */
    public static void main(String[] args) throws InterruptedException {
        MoveEntity moveEntity = new MoveEntity(10, 10);
        moveEntity.run();
    }

}
