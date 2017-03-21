package com.greensnow25.MoneyChanger;

/**
 * public class MoneyChanger.
 *
 * @author greensnow25.
 * @version 1.
 * @since 21.03.2017.
 */
public class MoneyChanger {

    /**
     * main.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        MoneyChanger moneyChanger = new MoneyChanger(args[0]);
        moneyChanger.giveMeMyMoney();
    }

    /**
     * Money to be exchanged.
     */
    private final int money;
    /**
     * coins for exchanged.
     */
    private final int[] coins = new int[]{10, 5, 2, 1};
    /**
     * Coin sequence upon change.
     */
    private int[] saveCheck = new int[50];
    /**
     * We use as a marker when adding the remainder at the first record.
     */
    private int pos = 0;
    /**
     * Balance for the first record.
     */
    private int balance = 0;

    /**
     * class constructor.
     *
     * @param money to be exchanged.
     */
    public MoneyChanger(String money) {
        this.money = Integer.parseInt(money);
        saveCheck[0] = Integer.parseInt(money);
    }

    /**
     * The method demonstrates all possible ways of exchanging money.
     */
    public void giveMeMyMoney() {
        for (int i = this.saveCheck.length - 1; i >= 0; i--) {
            for (int j = 0; j != this.coins.length; j++) {
                if (this.saveCheck[i] > this.coins[j]) {
                    int repetition = this.saveCheck[i] / this.coins[j];
                    this.balance = this.saveCheck[i] - this.coins[j] * repetition;
                    this.saveCheck = arrayFilling(repetition, this.coins[j], i);
                    printAraray();
                    giveMeMyMoney();
                }
            }
        }
    }

    /**
     * The method adds the remainder on the first input.
     *
     * @param repeat         Number of repetitions.
     * @param coinRepetition coin of repetition.
     * @param position       position on array.
     */
    public void addBalance(int repeat, int coinRepetition, int position) {
        for (int i = position; i != this.saveCheck.length; i++) {
            if (repeat > 0) {
                this.saveCheck[i] = coinRepetition;
                repeat--;
                if (repeat == 0) {
                    this.pos = 1;
                    break;
                }
            }
        }
    }

    /**
     * Number of repetitions.
     *
     * @param repetition     Number of repetitions.
     * @param coinRepetition coin of repetition.
     * @param position       position on array.
     * @return array of coins.
     */
    public int[] arrayFilling(int repetition, int coinRepetition, int position) {
        int count = repetition;
        for (int i = position; i != this.saveCheck.length; i++) {
            if (repetition > 0) {
                this.saveCheck[i] = coinRepetition;
                repetition--;
                if (repetition == 0) {
                    break;
                }
            }
        }
        if (pos == 0) {
            for (int j = 0; j != coins.length; j++) {
                if (this.balance > this.coins[j]) {
                    int repeat = this.balance / this.coins[j];
                    addBalance(repeat, this.coins[j], count);
                    break;
                }
            }
        }
        if (!isSum()) {
            for (int q = 0; q != this.saveCheck.length; q++) {

                if (this.saveCheck[q] == 0) {
                    this.saveCheck[q] = 1;
                    if (isSum()) {
                        break;
                    }
                }
            }
        }
        return saveCheck;
    }

    /**
     * The method checks whether the sum of coins in an array, the amount for exchange.
     *
     * @return true if equals.
     */
    public boolean isSum() {
        int sum = 0;
        for (int i = 0; i != this.saveCheck.length; i++) {
            if (this.saveCheck[i] != 0) {
                sum += this.saveCheck[i];
            }
        }
        if (sum == this.money) {
            return true;
        }
        return false;
    }

    /**
     * print saveCheck in console.
     */
    public void printAraray() {

        for (int i = 0; i != this.saveCheck.length; i++) {
            if (this.saveCheck[i] != 0) {
                System.out.print(String.format("%d ", saveCheck[i]));
            } else if (this.saveCheck[i] == 0) {
                System.out.println("");
                break;
            }
        }
    }
}
