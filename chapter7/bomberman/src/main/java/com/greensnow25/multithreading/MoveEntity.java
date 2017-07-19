package com.greensnow25.multithreading;

import com.greensnow25.modules.Board;

import java.util.concurrent.CyclicBarrier;

/**
 * Public class MoveEntity.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class MoveEntity {
    private final CyclicBarrier cyclicBarrier;
    private final Board board;


    public MoveEntity(int size, int countMonsters) {
        cyclicBarrier = new CyclicBarrier(countMonsters+1);
        board = new Board(size,countMonsters);
    }


}
