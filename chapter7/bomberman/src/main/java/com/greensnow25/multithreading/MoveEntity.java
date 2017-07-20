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
    private volatile boolean next;

    private final Board board;
    private ExecutorService ex;

    public MoveEntity(int size, int countMonsters) {
        this.ex = Executors.newFixedThreadPool(countMonsters + 1);
        this.board = new Board(size, countMonsters);
        this.next = false;
    }

    public Runnable createThreads(Cell monster) {
        return () -> {
            try {
                board.makeAMove(monster);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
    }


    public void createPool() throws InterruptedException {

        while (true) {
            for (Cell monster : board.getMonstersStorage()) {
                ex.execute(createThreads(monster));
            }
            Thread.sleep(10);
            ex.execute(new Runnable() {
                @Override
                public void run() {
                    board.getPlayer().getEntity().move(board.getPlayer());
                    next = true;
                }
            });
            //      ex.awaitTermination(1, TimeUnit.SECONDS);
            while (!next) Thread.sleep(10);
            System.out.println("wdqwdfwfw");
            board.createAndPrintBoard();
            next = false;


        }
    }

    public void run() throws InterruptedException {
        board.runBoard();
        createPool();
    }

    public static void main(String[] args) throws InterruptedException {
        MoveEntity moveEntity = new MoveEntity(10, 10);
        moveEntity.run();
    }

}
