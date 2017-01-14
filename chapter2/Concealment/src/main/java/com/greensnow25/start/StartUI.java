package com.greensnow25.start;

/**
 * public class StartUI run TRACKER.
 * @author grensnow25.
 * @since 28.12.16.
 * @version 1.0.
 */
public class StartUI {

    /**
     * method init run the aplication
     */
    public void init() {

       StubInput sb = new StubInput(1,1,"first","first");
       sb.choise();
        sb = new StubInput(3,1);
        sb.choise();




    }
    /**
     * main.
     * @param args string array.
     */
    public static void main(String[] args) throws Exception {

        new StartUI().init();

    }
}
