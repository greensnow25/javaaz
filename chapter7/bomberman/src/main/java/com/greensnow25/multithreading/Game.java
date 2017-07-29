package com.greensnow25.multithreading;


import com.greensnow25.entity.Barrier;
import com.greensnow25.entity.Entity;
import com.greensnow25.entity.Monster;
import com.greensnow25.entity.Player;
import com.greensnow25.input.MonsterInput;
import com.greensnow25.input.UserInput;
import com.greensnow25.modules.Board;
import com.greensnow25.modules.Cell;

import java.util.concurrent.*;

/**
 * Public class Game.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class Game {
    /**
     * class object.
     */
    private final Board board;
    /**
     * count monsters.
     */
    private int countMonsters;
    private  CyclicBarrier cyclicBarrier;

    /**
     * constructor.
     *
     * @param size          size .
     * @param countMonsters count of monsters.
     */
    public Game(int size, int countMonsters) {
        this.countMonsters = countMonsters;
        this.cyclicBarrier = new CyclicBarrier(this.countMonsters+1);

        this.board = new Board(size, this.cyclicBarrier);

    }

    public void queueSteps(){

    }

    /**
     * create thread pool.
     *
     * @throws InterruptedException
     */
    public void createUnits() throws InterruptedException {
        for (int i = 0; i!= countMonsters; i++){
            new Thread(new Monster(this.board,String.valueOf(i+1),new MonsterInput())).start();
            new Thread(new Barrier(this.board, new MonsterInput())).start();
        }

        new Thread(new Player(this.board, new UserInput())).start();
    }

    /**
     * run.
     *
     * @throws InterruptedException ex.
     */
    public void run() throws InterruptedException {
        board.createAndPrintBoard();
        createUnits();
    }

    /**
     * main.
     *
     * @param args args.
     * @throws InterruptedException ex.
     */
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(10, 1);
        game.run();
    }

}
