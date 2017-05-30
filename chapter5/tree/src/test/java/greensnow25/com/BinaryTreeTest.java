package greensnow25.com;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class BinaryTreeTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 30.05.2017.
 */
public class BinaryTreeTest {
    /**
     * class object.
     */
    BinaryTree<Integer> tree;

    /**
     * run before the test.
     */
    @Before
    public void beforeTheTest() {
        this.tree = new BinaryTree<>();
        tree.add(20);
        tree.add(16);
        tree.add(13);
        tree.add(10);
        tree.add(22);
        tree.add(25);
        tree.add(24);
        tree.add(21);
        tree.add(25);
    }

    /**
     * If the elements are added correctly, the return depth is 2.
     */
    @Test
    public void whenCallGetDepthThenReturnTwo() {

        assertThat(tree.getDepth(25), is(2));
    }

    /**
     * If the search element does not exist, return exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenCallGetDepthThenReturnException() {
        tree.getDepth(15);
    }

}