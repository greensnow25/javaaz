package greensnow25.com.linkedList;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class LinkedListTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 16.05.2017.
 */
public class LinkedListTest {
    /**
     * class object.
     */
    private SimpleLinkedList<String> simpleLinkedList;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.simpleLinkedList = new SimpleLinkedList<>();
        this.simpleLinkedList.add("1111");
        this.simpleLinkedList.add("2222");
        this.simpleLinkedList.add("3333");
        this.simpleLinkedList.add("4444");
    }

    /**
     * test add and get at one time.
     * add nodes to the list, then call method
     * get by index and return node from a given position.
     */
    @Test
    public void whenAddNodesThenReturnNode() {

        String res = this.simpleLinkedList.get(2);

        assertThat(res, is("3333"));
    }

    /**
     * test Iterator next. when Call four times return "4444".
     */
    @Test
    public void whenCallNextFourTimesThenReturnFour() {

        String res = null;
        Iterator iterator = this.simpleLinkedList.iterator();

        for (int i = 0; i < 4; i++) {
            res = (String) iterator.next();
        }

        assertThat(res, is("4444"));
    }

    /**
     * test hasNext() when call method t the beginning of the list.
     * then return true.
     */
    @Test
    public void whenCallHasNextAtTheBeginningThenReturnTrue() {

        boolean res = false;
        Iterator iterator = this.simpleLinkedList.iterator();

        assertTrue(iterator.hasNext());
    }

    /**
     * test hasNext(), when pointerbe on the end of list.
     * then return false.
     */
    @Test
    public void whenPointerLocateOnTheEndOfListThenReturnFalse() {
        Iterator iterator = this.simpleLinkedList.iterator();

        for (int i = 0; i < 4; i++) {
            iterator.next();
        }
        assertFalse(iterator.hasNext());
    }

    /**
     * when out of list range then throw NPE.
     */
    @Test(expected = NullPointerException.class)
    public void whenOutOfListThenThrowNPE() {
        Iterator iterator = this.simpleLinkedList.iterator();

        for (int i = 0; i < 5; i++) {
            iterator.next();
        }
    }

    /**
     * test removeLast. when remove then return last element
     */
    @Test
    public void whenRemoveLastThenReturnFour() {
        assertThat(simpleLinkedList.removeLast(), is("4444"));
    }

    /**
     * test removeLast. when remove then will change last element.
     */
    @Test
    public void whenRemoveLastThenLastElementIsThree() {

        simpleLinkedList.removeLast();

        assertThat( simpleLinkedList.get(simpleLinkedList.getSize()-1), is("3333"));
    }


    /**
     * test removeFirst. when remove then return last element
     */
    @Test
    public void whenRemoveFirstThenReturnOne() {
        assertThat(simpleLinkedList.removeFirst(), is("1111"));
    }

    /**
     * test removeFirst. when remove then will change first element.
     */
    @Test
    public void whenRemoveFirstThenFirstElementIsTwo() {

        simpleLinkedList.removeFirst();

        assertThat( simpleLinkedList.get(0), is("2222"));
    }
}