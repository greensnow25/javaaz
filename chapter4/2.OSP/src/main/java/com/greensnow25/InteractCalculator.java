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
     * array from actions with numbers.
     */
    private CalculatorAction[] actions = new CalculatorAction[8];

    /**
     * class constructor.
     *
     * @param input input system.
     */
    public InteractCalculator(Input input) {
        this.input = input;

    }



    /**
     * @param line input line.
     * @param patt pattern for search.
     *             make operation with one numbers.
     */
    public void assignValues(String line, String patt) {
        Pattern pattern = Pattern.compile(patt);
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            this.operationName = matcher.group(3);
            if (matcher.group(1) != null) {
                one = Double.parseDouble(matcher.group(1));
            } else {
                this.one = result;
            }
            this.two = Double.parseDouble(matcher.group(4));
        } else {

        }
    }


    /**
     * method selected an action and assign values.
     */
    public void choice() {
        for (OperationsOnse names : OperationsOnse.values()) {
            if (names.getOperation().equals(operationName)) {
              result = names.makeAction(one,two);
                break;
            }
        }
    }

    /**
     * choice operation.
     */
    public void run() {
        String line;
        System.out.println("push y for exit. ");
        while (!(line = input.answer("")).equals("y")) {

            assignValues(line, this.patt);
            this.choice();
            System.out.print(String.format("result = %.2f%s", result, System.getProperty("line.separator")));
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

    public double getOne() {
        return one;
    }

    public void setOne(double one) {
        this.one = one;
    }

    public double getTwo() {
        return two;
    }

    public void setTwo(double two) {
        this.two = two;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
}
