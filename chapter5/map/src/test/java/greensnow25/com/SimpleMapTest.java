package greensnow25.com;

import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class SimpleMapTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 25.05.2017.
 */
public class SimpleMapTest {
    /**
     * class object.
     */
    private SimpleMap<User, String> map;
    /**
     * class object.
     */
    private User userOne;
    /**
     * class object.
     */
    private User userTwo;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.map = new SimpleMap<>(3);
        this.userOne = new User("Alexandr", 0, new GregorianCalendar(25, 06, 1987));
        this.userTwo = new User("Alex", 0, new GregorianCalendar(25, 06, 1987));
    }

    /**
     * test insert(). when added value with original key, then return true.
     */
    @Test
    public void whenInsertThenReturnTrue() {

        assertThat(map.insert(userOne, "test"), is(true));
    }

    /**
     * test insert(). when added value with a key that already exists, then return false.
     */
    @Test
    public void whenInsertThenReturnFalse() {
        map.insert(userOne, "test");

        assertThat(map.insert(userOne, "test"), is(false));
    }

    /**
     * test get(). when call get() and key exist then return value.
     */
    @Test
    public void whenCallGetThenReturnValue() {
        map.insert(userOne, "test");

        assertThat(map.get(userOne), is("test"));
    }

    /**
     * test get(). when call get() and the key passed in the method does not exist, return null.
     */
    @Test
    public void whenCallGetThenReturnNull() {

        assertNull(map.get(userOne));
    }

    /**
     * test iterator.hasNext(), if after pointer exist elements, then return true.
     */
    @Test
    public void whenCallHasNextThenReturnTrue() {
        map.insert(userOne, "test");
        map.insert(userTwo, "test");
        Iterator iterator = map.iterator();
        iterator.next();

        assertTrue(iterator.hasNext());
    }

    /**
     * test iterator.hasNext(), if after pointer no elements exist, then return false.
     */
    @Test
    public void whenCallHasNextThenReturnFalse() {
        map.insert(userOne, "test");
        Iterator iterator = map.iterator();
        iterator.next();

        assertFalse(iterator.hasNext());
    }

    /**
     * test iterator.next(), if after pointer exist elements, then return value of element.
     */
    @Test
    public void whenCallNextThenReturnValue() {
        map.insert(userOne, "test");
        map.insert(userTwo, "test1");
        Iterator iterator = map.iterator();
        iterator.next();

        assertThat(iterator.next(), is("test"));
    }

    /**
     * test iterator.next(), if after pointer elements no exist, then return exception.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenCallNextThenReturnException() {
        map.insert(userOne, "test");
        map.insert(userTwo, "test1");
        Iterator iterator = map.iterator();
        for (int i = 0; ; i++) {
            iterator.next();
        }
    }

    /**
     * test delete(). when call method, then remove this element.
     */
    @Test
    public void whenCallDeleteThenNoElementOnTheMap() {
        map.insert(userOne, "test");
        map.insert(userTwo, "test1");
        map.delete(userOne);

        assertNull(map.get(userOne));
    }

    /**
     * test delete(). when call method, and deleted is successful, return true.
     */
    @Test
    public void whenCallDeleteThen() {
        map.insert(userOne, "test");
        map.insert(userTwo, "test1");

        assertThat(map.delete(userOne), is(true));
    }


}