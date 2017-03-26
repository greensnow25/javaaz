package com.greensnow25;

import com.greensnow25.input.Input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * public class Trigonometry.
 *
 * @author greensnow25.
 * @version 1.
 * @since 23.03.2017.
 */
public class Trigonometry extends InteractCalculator {
    /**
     * pattern.
     */
    private String pattern = "(\\w+[^0-9]+){1}(\\d*)";
    /**
     * operation name.
     */
    private String operationName;
    /**
     * number.
     */
    private String two;


    /**
     * class constructor.
     *
     * @param input input system.
     */
    public Trigonometry(Input input) {
        super(input);
    }

    @Override
    public boolean extend(String line) {
        Pattern patt = Pattern.compile(this.pattern);
        Matcher matcher = patt.matcher(line);
        if (matcher.find()) {
            operationName = matcher.group(1);
            two = matcher.group(2);
            return true;
        } else {

        }
        return false;
    }

    @Override
    public void choice() {
        boolean res = false;
        for (TrigonometricOperations operations : TrigonometricOperations.values()) {
            if (operations.getName().equals(operationName)) {
                setResult(operations.makeTrigOper(Double.parseDouble(two)));
                operationName = null;
                res = true;
                break;
            }
        }
        if (!res) {
            super.choice();
        }

    }
}
