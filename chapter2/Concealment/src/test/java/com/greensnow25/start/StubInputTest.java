package com.greensnow25.start;

import com.greensnow25.modules.Item;
import com.greensnow25.modules.Task;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Mama on 12.01.2017.
 */
public class StubInputTest {
    Task[] tasks = new Task[4];
    StubInput sb;
    Tracker tracker;
    Item item;

    @Before
    public void beforeTest(){
         this.sb =new StubInput();
        this.tracker = new Tracker();
        this.item = new Item();

    }
    @Before
    public void beforeTestOne(){
        Task[] result = this.tasks ;
        result[0] = new Task("one", "one");
        result[1] = new Task("two", "two");
        result[2] = new Task("three", "three");
        result[3] = new Task("four", "four");


    }
    @Test
    public void hello() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        hello();
        assertThat(out.toString(), is ("1 - Добавить заявку.\r\n 2 - Найти заявку по id\r\n 3 - Показать все заявки.\r\n 4 - Обновить заявку.\r\n 5 - Удалить заявку.\r\n 6 - Найти заявку по имени.\r\n 0 - выход из приложения\r\nвведите желаемое действие"));
    }

    @Test
    public void filing() {
        Task[] result = this.tasks ;
        result[0] = new Task("one", "one");
        sb.filing();
        assertThat(tasks[0], is(result[0]));
    }

    @Test
    public void choise() {

        sb.count =2;
        sb.scanInt = 1;


        ByteArrayOutputStream  out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String result = out.toString();

        sb.choise();
        assertThat(result, is("kn"));

    }

    @Test
    public void main() throws Exception {

    }

}