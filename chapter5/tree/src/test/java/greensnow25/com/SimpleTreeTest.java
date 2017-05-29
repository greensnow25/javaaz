package greensnow25.com;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

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
    /**
     * root.
     */
    private String root;

    /**
     * first level.
     */
    private String firstLevel;
    /**
     * second level.
     */
    private String secondLevel;

    /**
     * third level.
     */
    private String thirdLevel;

    @Before

    public void beforeTheTest() {
        this.root = "test";
        this.firstLevel = "Atest1";
        this.secondLevel = "Btest2";
        this.thirdLevel = "Ctest3";
        this.tree = new SimpleTree<>(root);
    }

    /**
     * Test method add(). If you correctly specify a structure for adding, then the truth is returned.
     */
    @Test
    public void whenAddThenReturnTrue() {
        tree.add(root, "D111");
        tree.add(root, firstLevel);

        boolean res = tree.add(firstLevel, "test4");

        assertTrue(res);
    }

    /**
     * Test method add(). If you do not correctly specify a structure for adding, then the truth is returned.
     */
    @Test
    public void whenAddThenReturnFalse() {

        assertFalse(this.tree.add("wrong", "structure"));
    }

    /**
     * Test hasNext(). If after the pointer the values ​​exist, the truth will return.
     */
    @Test
    public void whenCallHasNextThenReturnTrue() {
        tree.add(root, "D111");
        tree.add(root, firstLevel);
        tree.add(firstLevel, "F111");
        tree.add(firstLevel, firstLevel);
        Iterator iterator = tree.iterator();
        iterator.next();

        assertTrue(iterator.hasNext());
    }

    @Test
    public void ddd(){
        SimpleTree<Integer> s = new SimpleTree<>(20);

        s.add(20,10);
        s.add(10,13);
        s.add(10,12);
        s.add(20,14);
        s.add(14,3);

        Iterator iterator = s.iterator();
        iterator.next();

        assertTrue(iterator.hasNext());
    }


}