package greensnow25.com;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class SimpleTreeTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 29.05.2017.
 */
public class SimpleTreeTest {

    /**
     * class object.
     */
    private SimpleTree<String> tree;

    @Before

    public void beforeTheTest() {

        this.tree = new SimpleTree<>();
        tree.add("test", "test1");
        tree.add("test1", "test21");
        tree.add("test1", "test11");
        tree.add("test11", "TEST23");
    }

    /**
     * Test method add(). If you correctly specify a structure for adding, then the truth is returned.
     */
    @Test
    public void whenAddThenReturnTrue() {

        assertTrue(tree.add("test1", "test4"));
    }

    /**
     * Test method add(). If you do not correctly specify a structure for adding, then the truth is returned.
     */
    @Test
    public void whenAddThenReturnFalse() {

        assertFalse(this.tree.add("wrong", "structure"));
    }

    /**
     * Test next(). If after the pointer the values ​​exist, the next element will return.
     */
    @Test
    public void whenCallNextThenReturnTrue() {

        Iterator iterator = tree.iterator();
        iterator.next();

        assertThat(iterator.next(), is("test1"));
    }

    /**
     * Test next(). If after the pointer the values is no ​​exist, the exception will return.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenCallNextThenReturnException() {

        Iterator iterator = tree.iterator();
        for (int i = 0; ; i++) {
            iterator.next();
        }
    }

    /**
     * Test hasNext(). If after the pointer the values ​​exist, the truth will return.
     */
    @Test
    public void whenCallHasNextThenReturnTrue() {

        Iterator iterator = tree.iterator();
        iterator.next();
        iterator.next();

        assertTrue(iterator.hasNext());
    }

    /**
     * Test hasNext(). If after the pointer the values is no ​​exist, the false will return.
     */
    @Test
    public void whenCallHasNextThenReturnFalse() {

        Iterator iterator = tree.iterator();
        for (int i = 0; i != 4; i++) {
            iterator.next();
        }

        assertFalse(iterator.hasNext());
    }
}