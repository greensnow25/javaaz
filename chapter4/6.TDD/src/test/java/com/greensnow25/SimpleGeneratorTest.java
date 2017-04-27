package com.greensnow25;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class SimpleGeneratorTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.04.2017.
 */
public class SimpleGeneratorTest {
    /**
     * class object.
     */
    private SimpleGenerator simpleGenerator;
    /**
     * sentence for testing.
     */
    private String sentence;
    /**
     * map with keys and values.
     */
    private Map<String, String> map;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.simpleGenerator = new SimpleGenerator();
        this.sentence = "${computerLanguage} and ${Language} are the most popular language in the world";
        this.map = new HashMap<>();
        map.put("${computerLanguage}", "Java");
        map.put("${Language}", "English");
    }

    /**
     * when put sentence with keys, return sentences with values.
     */
    @Test
    public void whenPutSentenceWsthKeysThenReturnFullSentence() throws Bag {

        String result = simpleGenerator.generate(sentence, map);
        String expected = "Java and English are the most popular language in the world";

        assertThat(result, is(expected));
    }

    /**
     * When there are unused keys in the card return bag.
     *
     * @throws Bag bag.
     */
    @Test(expected = Bag.class)
    public void whenThereAreUnusedKeysInTheCardThenReturnBag() throws Bag {

        map.put("${badKey}", "exception");

        simpleGenerator.generate(sentence, map);
    }

    /**
     * when key is not found return the bag.
     *
     * @throws Bag bag.
     */
    @Test(expected = Bag.class)
    public void whenKeyIsNotFoundThenReturnBag() throws Bag {

        this.sentence = "${computerLanguage} and ${something} are the most popular language in the world";

        simpleGenerator.generate(sentence, map);
    }


}