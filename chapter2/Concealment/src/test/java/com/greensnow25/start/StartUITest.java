package com.greensnow25.start;

import com.greensnow25.modules.Item;
import com.greensnow25.modules.Task;
import com.sun.org.glassfish.external.arc.Stability;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Mama on 11.01.2017.
 */
public class StartUITest {
    ByteArrayOutputStream out;
    Tracker tracker;
    Item item;
    String nameOne = "first";
    String discOne = "first";
    String[] action = new String[]{"0","1","2","3","4","5","6"};
    String nameTwo = "two";
    String diskTwo = "two";
    String id = "123";
    @Before
    public void befoteTest() {
       this.out = new ByteArrayOutputStream();
        this.tracker = new Tracker();
        this.item = new Item();
    }
    @Test

    public void whenAddItemtThenFindByNameAndPrint() {
        System.setOut(new PrintStream(out));


        Input input = new StubInput(new String[]{action[1], nameOne, discOne, action[0]});
        new StartUI(input).choise();
        String result =out.toString();
        assertThat(result, is("Заявка first добавлена\r\n"));

    }
    @Test
    public void whenFindByIdReturnItemIdAndPrint() {

        item = tracker.add(new Task(nameOne,discOne));

         item = tracker.findByName(nameOne);
         id =item.getId();

        Input input = new StubInput(new String[]{action[2], id});
        System.setOut(new PrintStream(out));
        new StartUI(input).choise();
        String result = out.toString();
        assertThat(result, is("uh"));
    }

    @Test
    public void whenAddItemThenShowItems() {
        Input input = new StubInput(new String[]{action[1], nameOne, discOne, action[3], action[0]});
        System.setOut(new PrintStream(out));
        new StartUI(input).choise();
        String result = out.toString();
        assertThat(result, is ("Заявка first добавлена\r\n" +
                                             "first  first\r\n"));
    }

    @Test
    public void whenAddItemThenFindAndUpdateThen() {
        Input input = new StubInput(new String[]{action[1], nameOne, discOne, action[1], nameTwo, diskTwo,
                                                action[4], nameOne , nameTwo, diskTwo, action[3], action[0]});
        System.setOut(new PrintStream(out));
        new StartUI(input).choise();
        String result = out.toString();
        assertThat(result, is("Заявка first добавлена\r\n" +
                              "Заявка two добавлена\r\n" +
                              "two  two\r\n" +
                              "two  two\r\n"));
    }
    @Test
    public void whenDeleteItemThenShowAll() {
        Input input = new StubInput(new String[]{action[1], nameOne, discOne, action[1], nameTwo, diskTwo,
                                                 action[5], nameOne, action[3], action[0]});
        System.setOut(new PrintStream(out));
        new StartUI(input).choise();
        String result = out.toString();
        assertThat(result, is("Заявка first добавлена\r\n" +
                              "Заявка two добавлена\r\n" +
                              "Заявка first удалена.\r\n" +
                              "two  two\r\n"));
    }

    @Test
    public void whenFindByNameThenReturnItem() {
        Input input = new StubInput(new String[]{action[1], nameOne, discOne, action[6], nameOne, action[0]});
        System.setOut(new PrintStream(out));
        new StartUI(input).choise();
        String result = out.toString();
        assertThat(result, is("Заявка first добавлена\r\n" +
                              "Заявка найдена : first  first\r\n"));
    }

}