package com.greensnow25;

import com.greensnow25.ConsoleChatLibery.StubInput;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class ConsoleChatTest {
    /**
     * class object.
     */
    private ConsoleChat chat;

    /**
     * input answers.
     */
    private String[] answers = new String[]{"hello", "wait", "dsfefw", "resume", "lets start", "stop"};
    /**
     * input system.
     */
    StubInput stubInput;

    /**
     * method call before testing.
     */
    @Before
    public void beforeTest() {
        this.stubInput = new StubInput(answers);
        this.chat = new ConsoleChat(stubInput);

    }

    /**
     * The method checks to see if the file was created.
     *
     * @throws Exception file not found.
     */
    @Test
    public void whenCreateTextFileReturnNotNull() throws Exception {
        File file = chat.createTextFile();
        assertNotNull(file);
    }

    /**
     * The method generates a random word and compares it to a word in the file.
     *
     * @throws Exception ex.
     */
    @Test
    public void generateRandomWord() throws Exception {
        File file = chat.createTextFile();
        String word = chat.generateRandomWord();
        String tmp;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((tmp = br.readLine()) != null) {
                if (word.equals(tmp)) {
                    break;
                }
            }
        }
        assertThat(word, is(tmp));
    }

    @Test
    public void whenMethodRunWellThenReturnFalse(){
        boolean result;
               result = chat.chat();
        //значение result приходит false, но тест не проходит((.
        assertFalse(result);
    }

}