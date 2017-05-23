package greensnow25.com.SimpleHashSet;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class SimpleHashSetTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 23.05.2017.
 */
public class SimpleHashSetTest {
    /**
     * class object.
     */
    private SimpleHashSet<String> set;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.set = new SimpleHashSet<>(16);
        for (int i = 0; i != 3; i++) {
            set.add("test" + i);
        }
    }

    /**
     * test add. If the value added is original,.
     * then there is an addition to the set and the true is returned.
     */
    @Test
    public void whenValueIsOriginThenAddToTheSet() {

        assertTrue(set.add("test3"));
    }

    /**
     * test add. If the value added is not original,.
     * then there is no addition to the set and the false is returned.
     */
    @Test
    public void whenValueIsNotOriginThenReturnFalse() {


        assertFalse(set.add("test1"));
    }

    /**
     * test iterator hasNext(). If after the pointer there are elements, return true.
     */
    @Test
    public void whenCallHasNextThenReturnTrue() {

        Iterator iterator = set.iterator();
        iterator.next();
        assertTrue(iterator.hasNext());
    }

    /**
     * test iterator hasNext(). If after the pointer there are no elements, return false.
     */
    @Test
    public void whenCallHasHextThenReturnFalse() {

        Iterator iterator = set.iterator();
        for (int i = 0; i != 3; i++) {
            iterator.next();
        }
        assertFalse(iterator.hasNext());
    }

    /**
     * test iterator next().If after the pointer there are elements, then return next element.
     */

    @Test
    public void whenCallNextThenReturnElement() {

        Iterator iterator = set.iterator();
        iterator.next();

        assertThat(iterator.next(), is("test0"));
    }

    /**
     * test iterator next().If after the pointer there are no elements, then return Exception..
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenCallNextThenReturnException() {
        Iterator iterator = set.iterator();
        for (int i = 0; ; i++) {
            iterator.next();
        }
    }


}