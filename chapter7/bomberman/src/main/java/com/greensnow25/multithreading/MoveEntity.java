package com.greensnow25.multithreading;

import com.greensnow25.entity.MyMonsterTwo;
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
    // private final CyclicBarrier cyclicBarrier;
    private final Board board;
    private ExecutorService ex = Executors.newFixedThreadPool(4);

    public MoveEntity(int size, int countMonsters) {
        // cyclicBarrier = new CyclicBarrier(countMonsters+1);
        board = new Board(size, countMonsters);
    }

    public Runnable createThreads(Cell monster) {
        return new Runnable() {
            @Override
            public void run() {

                try {
                    board.makeAMove(monster);
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        };
    }


    public void createPool() throws InterruptedException {
        while (true) {
            for (Cell monster : board.getMonstersStorage()) {
                ex.execute(createThreads(monster));
            }

            ex.execute(new Runnable() {
                @Override
                public void run() {
                    board.getPlayer().getEntity().move(board.getPlayer());
                }
            });
            ex.awaitTermination(10, TimeUnit.SECONDS);
            board.createAndPrintBoard();


        }
    }

    public void run() throws InterruptedException {
        board.runBoard();
        createPool();
    }

    public static void main(String[] args) throws InterruptedException {
        MoveEntity moveEntity = new MoveEntity(10, 5);
        moveEntity.run();
    }

}
