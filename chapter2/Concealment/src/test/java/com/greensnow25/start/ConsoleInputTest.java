package com.greensnow25.start;

import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Public class ConsoleInputTest test aplication with data static.
 * @author greensnow25.
 * @since 11.01.17.
 * @versuon 1.
 */
public class ConsoleInputTest {
    @Test
    /**
     * public method hello - welcome user.
     */
    public void hello() {
        ByteArrayOutputStream out =new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        hello();
        String sep = System.getProperty("line.separator");
        System.out.format("1 - Добавить заявку.",
                          "2 - Найти заявку по id",
                          "3 - Показать все заявки.",
                          "4 - Обновить заявку.",
                          "5 - Удалить заявку.",
                          "6 - Найти заявку по имени.",
                          "0 - выход из приложения",
                          "введите желаемое действие"  );

        assertThat(out.toString(), is( System.out.format(" ")));
    }

    @Test
    public void choise() {
    Tracker tracker = new Tracker();
        hello();

    }

    @Test
    public void close() throws Exception {

    }

}