package com.greensnow25.multithreading;


import com.greensnow25.units.Barrier;
import com.greensnow25.units.Monster;
import com.greensnow25.units.Player;
import com.greensnow25.input.MonsterInput;
import com.greensnow25.input.UserInput;
import com.greensnow25.board.Board;

import javax.xml.bind.annotation.XmlType;
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
    /**
     * cycle barrier.
     */
    private CyclicBarrier cyclicBarrier;
    /**
     * Default size of the model.
     */
    private final static int DEFAULT_BOARD_FIELD_SIZE = 5;
    /**
     * Number of default monsters.
     */
    private final static int NUMBER_OF_DEFAULT_MONSTERS = 3;

    /**
     * Default constructor.
     */
    public Game() {
        this(DEFAULT_BOARD_FIELD_SIZE, NUMBER_OF_DEFAULT_MONSTERS);
    }

    /**
     * constructor.
     *
     * @param size          size .
     * @param countMonsters count of monsters.
     */
    public Game(int size, int countMonsters) {
        this.countMonsters = countMonsters;
        this.cyclicBarrier = new CyclicBarrier(this.countMonsters + 1);

        this.board = new Board(size, this.cyclicBarrier);

    }

    /**
     * create Units.
     *
     * @throws InterruptedException
     */
    public void createUnits() throws InterruptedException {
        for (int i = 0; i != countMonsters; i++) {
            new Thread(new Monster(this.board, new MonsterInput())).start();
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
        board.createOrPrintBoard();
        createUnits();
    }

    /**
     * main.
     *
     * @param args args.
     * @throws InterruptedException ex.
     */
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(10, 3);
        game.run();
    }

}
