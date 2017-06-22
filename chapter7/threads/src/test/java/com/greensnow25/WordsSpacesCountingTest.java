package com.greensnow25;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class WordsSpacesCountingTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 09.06.2017.
 */
public class WordsSpacesCountingTest {
    /**
     * class object.
     */
    private WordsSpacesCounting ws;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest(){
        this.ws = new WordsSpacesCounting("wdwed ewf ewf wefwe f ef dsf sd f we2 7");
    }

    /**
     * when call method countWords return 11.
     */
    @Test
    public void whenCallCountWordsThenReturnEleven(){
      //  assertThat(ws.countWords(), is(11));
    }
    /**
     * when call method countSpaces return 10.
     */
    @Test
    public void whenCallCountSpacesThenReturnTen(){
      //  assertThat(ws.countSpaces(), is(10));
    }

}