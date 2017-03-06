package com.greensnow25;

import com.greensnow25.ConsoleChatLibery.ConsoleInput;
import com.greensnow25.ConsoleChatLibery.Input;

import java.io.*;
import java.util.Random;

/**
 * public class ConsoleChat shows how chat is working.
 * if you enter any word, chat answer to you, random fraze from text file.
 * if you enter "wait", progra stop answer to you messages.
 * if you enter "resume", program resume answer to yoy
 * and if enter "stop", program quits.
 *
 * @author greensnow25.
 * @version 1.
 * @since 06.03.17.
 */
public class ConsoleChat {
    public static void main(String[] args) {
        ConsoleChat chat = new ConsoleChat();
        chat.chat(new ConsoleInput());
    }

    /**
     * default constructor.
     */
    public ConsoleChat() {

    }

    /**
     * constructor of class.
     *
     * @param input input system.
     */
    public ConsoleChat(Input input) {
        this.input = input;
    }

    /**
     * words array, of then generate random answers.
     */
    private String[] randomWords = new String[]{"джава ", "привет ", "модуль ", "планктон ", "овчарка ", "добрый ", "козленок "};
    /**
     * generated file.
     */
    private File randomFrazes;
    /**
     * input system.
     */
    private Input input;

    /**
     * method gnerate the temp file.
     *
     * @param randomWords array of words.
     * @return generated file comprising random frazes.
     * @throws IOException ex.
     */
    public File createTextFile(String[] randomWords) throws IOException {
        String separator = System.getProperty("line.separator");
        File randomFrazes = File.createTempFile("randomFrazes", ".txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(randomFrazes))) {
            for (int i = 0; i != randomWords.length; i++) {
                bw.write(randomWords[i] + separator);
            }
        }
        return randomFrazes;
    }

    /**
     * method generate random word from file.
     *
     * @return word.
     * @throws IOException ex.
     */
    public String generateRandomWord() throws IOException {
        File file = createTextFile(randomWords);
        String word = "";
        int len = randomWords.length;
        try (BufferedReader bof = new BufferedReader(new FileReader(file))) {
            Random random = new Random();
            int number = random.nextInt(len);
            for (int i = 0; i != len; i++) {
                word = bof.readLine();
                if (number == i) {
                    break;
                }
            }
        }
        return word;
    }

    /**
     * method run chat.
     *
     * @param input input system.
     * @return boolean using for testing.
     */
    public boolean chat(Input input) {
        String word = "";
        boolean res = true;
        String randomWord;
        try {


            try (PrintWriter pw = new PrintWriter(new File("D:\\log.txt"))) {
                randomFrazes = createTextFile(randomWords);
                do {
                    word = input.answer();
                    randomWord = generateRandomWord();
                    if (word.equals("wait")) {
                        waitResume(input);
                    } else {
                        pw.write(randomWord);
                    }
                } while (!word.equals("stop"));
           res = false;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        randomFrazes.deleteOnExit();
        return res;

    }

    /**
     * method resume, if enter "resume".
     *
     * @param input input system.
     * @return boolean for testing.
     * @throws IOException ex.
     */
    public boolean waitResume(Input input) throws IOException {
        boolean res = false;
        String word;
        do {
            word = input.answer();
            if (word.equals("resume")) {
                res = true;
            }

        } while (!res);
        return res;
    }

}

