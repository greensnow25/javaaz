package greensnow25.com.array;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class SimpleSetTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.05.2017.
 */
public class SimpleSetTest {
    /**
     * set.
     */
    private SimpleSet<Integer> set;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.set = new SimpleSet<>(10);
        set.add(1);
        set.add(2);
    }

    /**
     * test method add(), if add success, then position on SimpleSet class equals 2.
     */ /**
     * test method add(), if add success, then position on SimpleSet class equals 2.
     */
    @Test
    public void whenAddOriginalElementThenItAddToTheArray() {
        set.add(3);
        set.add(4);
        assertThat(set.getPosition(), is(4));
    }


    /**
     * test method add(), if add  no success, then position on SimpleSet class equals 1.
     */
    @Test
    public void whenAddDuplicateThenItNoAddToTheArray() {
        set.add(1);
        set.add(1);
        assertThat(set.getPosition(), is(2));
    }

    /**
     * test hasNext(),when iterator call hasNext() and after pointer position be available elements then return true.
     */
    @Test
    public void whenIteratorCallHasNextAndAfterPointerPositionBeAvailableElementsThenReturnTrue() {
        Iterator iterator = set.iterator();
        iterator.next();
        assertTrue(iterator.hasNext());
    }
    /**
     * test hasNext(),when iterator call hasNext() and after pointer position no elements then return false.
     */
    @Test
    public void whenIteratorCallHasNextAndAfterPointerPositionNoElementsThenReturnfalse() {
        Iterator iterator = set.iterator();
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    /**
     * test next(). when call next() and after pointer position be available element, then return element.
     */
    @Test
    public void whenIteratorCallNextThenReturnNextElement(){
        Iterator iterator = set.iterator();
        iterator.next();
        assertThat(iterator.next(), is(2));
    }

    /**
     * test next(). when call next() and after pointer position no elements element, then throw exseption.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenIteratorCallNextAndNoMoreElementAfterPoinerThenThrowException(){
        Iterator iterator = set.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
    }

}