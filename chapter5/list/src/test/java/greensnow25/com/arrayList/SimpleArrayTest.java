package greensnow25.com.arrayList;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * public class SimpleArrayTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 16.05.2017.
 */
public class SimpleArrayTest {
    /**
     * class object.
     */
    private SimpleArray<String> strList;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.strList = new SimpleArray<>();
    }


    /**
     * test add string on first position on the array, then get him.
     */
    @Test
    public void whenCallAddThenReturnsameObject() {
        strList.add("test");

        assertThat(strList.get(0), is("test"));
    }

    /**
     * test increase the size of the array.
     */
    @Test
    public void whenCallAddTenTimesThenArraySizeEqualsSixteen() {
        for (int i = 0; i != 10; i++) {
            strList.add("test" + i);

        }
        assertThat(this.strList.getArray().length, is(16));
    }

    /**
     * test iterator hasNext.
     */
    @Test
    public void whenCallHasNextInTheBeginningOfTheArrayThenReturnTrue() {
        boolean res = false;
        strList.add("test");
        strList.add("test");

        Iterator<String> it = this.strList.iterator();
        for (int i = 0; i != 10; i++) {
            res = it.hasNext();
        }
        assertThat(res, is(true));
    }

    /**
     * test iterator next(), when we call the method twice, then must return some value.
     */
    @Test
    public void whenCallNextThenReturnItem() {
        strList.add("test");
        strList.add("test one");
        Iterator<String> it = this.strList.iterator();
        it.next();
        assertThat(it.next(), is("test one"));
    }

    /**
     * when call next() twice then throw ArrayIndexOutOfBoundsException.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenCallNextThreeTimesThenReturnException() {
        strList.add("test");
        Iterator<String> it = this.strList.iterator();
        it.next();
        it.next();
    }

    /**
     * test hasNext() return false if pointer stay in the enh of array.
     */
    @Test
    public void whenPointerInTheEndOfArrayThenMethodHasNextReturnFalse() {
        strList.add("test");
        Iterator<String> it = this.strList.iterator();
        it.next();
        assertFalse(it.hasNext());
    }


}