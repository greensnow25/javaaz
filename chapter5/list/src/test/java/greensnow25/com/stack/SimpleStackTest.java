package greensnow25.com.stack;

import greensnow25.com.linkedList.SimpleLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class SimpleStackTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 17.05.2017.
 */
public class SimpleStackTest {
    /**
     * class object.
     */
    private SimpleStack<String> stack;
    /**
     * class object.
     */
    private SimpleLinkedList<String> link;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.link = new SimpleLinkedList();

        link.add("1111");
        link.add("2222");
        link.add("3333");
        link.add("4444");
        link.add("5555");
        this.stack = new SimpleStack<>(this.link);

    }

    /**
     * test method peek(), must return last element from the list, with out remove.
     */
    @Test
    public void whenAddElementsInTheEndOfTheListThenReturnLastElementWithOutNoRemove() {

        assertThat(stack.peek(), is("5555"));
    }

    /**
     * test method peek(), check last element..
     */
    @Test
    public void whenCallPeekThenLastElementDoNotRemove() {

        stack.peek();

        assertThat(link.get(link.getSize()-1), is("5555"));
    }

    /**
     * test pop(). when call then return last item.
     */
    @Test
    public void whenCallPopThenReturnLastItem() {

        String res = stack.pop();

        assertThat(res, is("5555"));
    }

    /**
     * test pop. remove three elements from the top of stack.
     */
    @Test
    public void whenCallPopThreeTimesThenRemoveThreeElementsFromTheEnd() {
        for (int i = 0; i < 3; i++) {
            stack.pop();
        }
        assertThat(link.get(link.getSize()-1), is("2222"));
    }

    /**
     * test search. return number of necessary calls of pop() method.
     */
    @Test
    public void whenCallSearchThenReturnCountOfMoves() {

        int res = stack.search("2222");

        assertThat(res, is(3));
    }

    /**
     * test search. if no maches then return -1.
     */
    @Test
    public void whenNoMatchesThenReturnMinusOne() {

        int res = stack.search("1234");

        assertThat(res, is(-1));
    }


}