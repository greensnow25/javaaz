package com.greensnow25;

import com.greensnow25.ConsoleChatLibery.ConsoleInput;
import com.greensnow25.ConsoleChatLibery.Input;
import com.greensnow25.ConsoleChatLibery.StubInput;
import jdk.internal.util.xml.impl.ReaderUTF8;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class ConsoleChatTest {
    ConsoleChat chat;
    String[] randomWords = new String[]{"джава ", "привет ", "модуль ", "планктон ", "овчарка ", "добрый ", "козленок "};
    String[] answers = new String[]{"hello", "wait", "dsfefw", "resume", "lets start", "stop"};
   // Input input;
    StubInput stubInput;
    @Before
    public void beforeTest() {
        this.stubInput = new StubInput(answers);
        this.chat = new ConsoleChat(stubInput);

    }

    @Test
    public void whenCreateTextFileReturnNotNull() throws Exception {
        File file = chat.createTextFile(randomWords);
        assertNotNull(file);
    }

    @Test
    public void generateRandomWord() throws Exception {
        File file = chat.createTextFile(randomWords);
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
    public void chat() throws Exception {

        boolean res = true;
        chat.createTextFile(randomWords);

        res = chat.chat(stubInput);
        assertTrue(!res);


    }

    @Test
    public void whenenterResumeThenContinueTheProgramm() throws Exception {
        String[] resume = new String[]{ "resume"};
        StubInput sbOne = new StubInput(resume);
        boolean res = false;
        chat.waitResume(sbOne);
        assertTrue(true);


    }

}