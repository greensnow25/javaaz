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
     *
     * @param args args.
     */
    public static void main(String[] args) {
        InteractCalculator interactCalculator = new InteractCalculator(new ConsolInput());
        interactCalculator.run();
    }

    /**
     * number one.
     */
    private double one;
    /**
     * number two.
     */
    private double two;
    /**
     * result of operations.
     */
    private double result;
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
    private final String patt = "([-]?\\d+(\\.\\d*)?)?([+-/*]{1})([-]?\\d+(\\.\\d*)?)";
    /**
     * bad command flag.
     */
    private boolean badCommand = false;
    /**
     * array from actions with numbers.
     */
    private CalculatorAction[] actions = new CalculatorAction[4];
    /**
     * class object.
     */
    private Calculator calculator;

    /**
     * class constructor.
     *
     * @param input input system.
     */
    public InteractCalculator(Input input) {
        this.input = input;
        this.calculator = new Calculator();
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
     * make operation with one numbers.
     */
    public void assignValues(String line, String patt) {
        Pattern pattern = Pattern.compile(patt);
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            operationName = matcher.group(3);
            if (matcher.group(1) != null) {
                one = Double.parseDouble(matcher.group(1));
            } else {
                one = result;
            }
            two = Double.parseDouble(matcher.group(4));
        } else {
            System.out.println("bad command. try again ");
        }
    }

    /**
     * method selected an action and assign values.
     */
    public void choice() {
        for (Operations names : Operations.values()) {
            if (names.operation.equals(operationName)) {
                actions[names.ordinal()].makeAction(one, two);
                break;
            }
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

            assignValues(line, this.patt);
            this.choice();
            System.out.print(String.format("result = %.2f%s", result, System.getProperty("line.separator")));
        }
    }

    /**
     * inner class Add.
     */
    private class Add implements CalculatorAction {

        @Override
        public double makeAction(double one, double two) {
            calculator.add(one, two);
            return result = calculator.result;
        }
    }

    /**
     * inner class Sub.
     */
    private class Sub implements CalculatorAction {

        @Override
        public double makeAction(double one, double two) {
            calculator.substract(one, two);
            return result = calculator.result;
        }
    }

    /**
     * iner class Split.
     */
    private class Split implements CalculatorAction {

        @Override
        public double makeAction(double one, double two) {
            calculator.div(one, two);
            return result = calculator.result;
        }
    }

    /**
     * inner class Multiply.
     */
    private class Multiply implements CalculatorAction {

        @Override
        public double makeAction(double one, double two) {
            calculator.multiple(one, two);
            return result = calculator.result;
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
         *
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
    public double getResult() {
        return result;
    }
}
