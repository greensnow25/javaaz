package com.greensnow25;

import com.greensnow25.input.ConsolInput;
import com.greensnow25.input.Input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * public class InteractCalculator.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.03.2017.
 */
public class InteractCalculator {
    /**
     * main.
     * @param args args.
     */
    public static void main(String[] args) {
        InteractCalculator interactCalculator = new InteractCalculator(new ConsolInput());
        interactCalculator.run();
    }

    /**
     * number one.
     */
    private int one;
    /**
     * number two.
     */
    private int two;
    /**
     * result of operations.
     */
    private int result;
    /**
     * input line split to symbols.
     */
    private String[] symbols;
    /**
     * input system.
     */
    private Input input;
    /**
     * operation name.
     */
    private String operationName;
    /**
     * pattern for search.
     */
    private final String patt = "([+-/*]{1})(\\d+$)";
    /**
     * bad command flag.
     */
    private boolean badCommand = false;
    /**
     * array from actions with numbers.
     */
    private CalculatorAction[] actions = new CalculatorAction[4];

    /**
     * class constructor.
     *
     * @param input input system.
     */
    public InteractCalculator(Input input) {
        this.input = input;
    }

    /**
     * filling array actions.
     */
    public void filling() {
        int count = 0;
        actions[count++] = this.new Add();
        actions[count++] = this.new Sub();
        actions[count++] = this.new Split();
        actions[count++] = this.new Multiply();
    }

    /**
     * @param line input line.
     * @param patt pattern for search.
     * @return false if make operation from two numbers, and true if
     * make operation with one numbers.
     */
    public boolean compareAndSplit(String line, String patt) {

        Pattern pattern = Pattern.compile(patt);

        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            operationName = matcher.group(1);

            symbols = line.split("\\" + operationName);
            if (symbols[0].equals("") && symbols.length != 3) {
                badCommand = false;
                return true;
            }
        } else {
            badCommand = true;
        }
        return false;
    }

    /**
     * method selected an action and assign values.
     * @param addToResult where to add.
     */
    public void choice(boolean addToResult) {
        if (!badCommand) {
            if (addToResult) {
                this.one = this.result;
                two = Integer.parseInt(symbols[1]);

            } else if (symbols.length == 3) {
                one = -Integer.parseInt(symbols[1]);
                two = Integer.parseInt(symbols[2]);
            } else if (!addToResult) {
                one = Integer.parseInt(symbols[0]);
                two = Integer.parseInt(symbols[1]);

            }
            for (Operations names : Operations.values()) {
                if (names.operation.equals(operationName)) {
                    actions[names.ordinal()].makeAction(one, two);
                    break;
                }

            }
        } else {
            System.out.println("bad command try again.");
        }
    }

    /**
     * choice operation.
     */
    public void run() {
        filling();
        String line;
        System.out.println("push y for exit. ");
        while (!(line = input.answer("")).equals("y")) {

            boolean addToResult = compareAndSplit(line, this.patt);
            this.choice(addToResult);

            System.out.printf(" = %d%s", result, System.getProperty("line.separator"));
        }
    }

    /**
     * inner class Add.
     */
    public class Add implements CalculatorAction {

        @Override
        public int makeAction(int one, int two) {

            return result = one + two;
        }
    }

    /**
     * inner class Sub.
     */
    public class Sub implements CalculatorAction {

        @Override
        public int makeAction(int one, int two) {
            return result = one - two;
        }
    }

    /**
     * iner class Split.
     */
    public class Split implements CalculatorAction {

        @Override
        public int makeAction(int one, int two) {
            return result = one / two;
        }
    }

    /**
     * inner class Multiply.
     */
    public class Multiply implements CalculatorAction {

        @Override
        public int makeAction(int one, int two) {
            return result = one * two;
        }
    }

    /**
     * enum of operations.
     */
    enum Operations {
        /**
         * add.
         */
        ADD("+"),
        /**
         * sub.
         */
        SUB("-"),
        /**
         * split.
         */
        SPLIT("/"),
        /**
         * myltiply.
         */
        MYLTIPLY("*");
        /**
         * kind of operation.
         */
        private String operation;

        /**
         * enum cons.
         * @param operation key.
         */
        Operations(String operation) {
            this.operation = operation;
        }

    }

    /**
     * get result.
     *
     * @return result.
     */
    public int getResult() {
        return result;
    }
}
