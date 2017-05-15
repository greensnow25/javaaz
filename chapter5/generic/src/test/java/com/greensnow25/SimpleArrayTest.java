package com.greensnow25;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class SimpleArrayTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 15.05.2017.
 */
public class SimpleArrayTest {

    private SimpleArray<String> stringList;

    private SimpleArray<Integer> integerList;

    @Before
    public void beforeTheTest(){
        this.stringList = new SimpleArray<String>();
        this.integerList = new SimpleArray<Integer>();

        stringList.add("test");
    }

    /**
     * test add to the list.
     */
    @Test
    public void whenAddStringItemThenRetrnItem(){



        assertThat(stringList.get(0), is("test"));
    }

    /**
     * rest remove item.
     */
    @Test
    public void whenRemoveItemThenReturnNull(){

        stringList.delete("test");

        assertNull(stringList.search("test"));
    }

    @Test
    public void whenUpdateElementThenReturnNewElement(){

        stringList.update("test", "new test");

        assertThat(stringList.get(0), is("new test"));
    }






}