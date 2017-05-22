package greensnow25.com.queue;

import greensnow25.com.linkedList.SimpleLinkedList;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class SimpleQueueTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.05.2017.
 */
public class SimpleQueueTest {
    /**
     * class object.
     */
    private SimpleQueue<String> queue;
    /**
     * class object.
     */
    private SimpleLinkedList<String> linkedList;

    @Before
    public void beforeTheTest() {
        this.linkedList = new SimpleLinkedList<>();
        this.linkedList.add("1111");
        this.linkedList.add("2222");
        this.linkedList.add("3333");
        this.linkedList.add("4444");
        this.linkedList.add("5555");
        this.queue = new SimpleQueue<>(this.linkedList);
    }

    /**
     * test method T element(), return element from the beginning of the queue.
     */
    @Test
    public void whenCallElementThenReturnElementFromTheBeginningOfTheQueue() {

        assertThat(this.queue.element(), is("1111"));
    }

    /**
     * test method element(), when call element() and queue is empty then throw exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenQueueIsEmptyThenReturnException() {

        new SimpleQueue<String>(new SimpleLinkedList<>()).element();
    }

    /**
     * test offer. if add return true.
     */
    @Test
    public void whenAddElementThenReturnTrue() {

        assertThat(this.queue.offer("1223"), is(true));
    }

    /**
     * test method peek(), when call then return first element from the queue.
     */
    @Test
    public void wheeCallPeekThenReturnFirstElementFromTheQueue() {

        assertThat(queue.peek(), is("1111"));
    }

    /**
     * test method peek(), when call peek() and queue is emt, then return null.
     */
    @Test
    public void whenQueueIsEmptyAndCallPeekThenReturnNull() {

        assertNull(new SimpleQueue<String>(new SimpleLinkedList<>()).peek());
    }

    /**
     * test method poll() when call twice, then first element in the queue is three.
     */
    @Test
    public void whenCallPoolWtwiceThenFirstElementIsThree() {
        queue.poll();
        queue.poll();

        assertThat(linkedList.get(0), is("3333"));
    }

    /**
     * test method poll(), when call poll() and queue is empty, then return null.
     */
    @Test
    public void whenCallPoolAndQueueIsEmpteThenReturnNull() {

        assertNull(new SimpleQueue<String>(new SimpleLinkedList<>()).poll());
    }

    /**
     * test method remove(), when call method, then return removing element.
     */
    @Test
    public void whenCallRemoveThenReturnRemovingElement(){

        assertThat(queue.remove(), is("1111"));
    }

    /**
     * test method remove(), when call method and queue is empty, then return exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenCallRemoveAndQueueIsEmptyThenReturnException(){

        new SimpleQueue<String>(new SimpleLinkedList<>()).remove();
    }

}