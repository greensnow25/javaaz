package greensnow25.com.link;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class SimpleLinkedSetTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.05.2017.
 */
public class SimpleLinkedSetTest {

    private SimpleLinkedSet<Integer> set;

    @Before
    public void beforeTheTest() {
        this.set = new SimpleLinkedSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
    }

    /**
     * test method add(), if add success, then size on SimpleListSet class equals 4.
     */
    @Test
    public void whenAddOriginalElementThenItAddToTheSet() {
        set.add(4);
        assertThat(set.getSize(), is(4));
    }

    /**
     * test method add(), if add  no success, then position on SimpleSet class equals 3.
     */
    @Test
    public void whenAddDuplicateThenItNoAddToTheSet() {
        set.add(1);
        set.add(3);
        assertThat(set.getSize(), is(3));
    }


}