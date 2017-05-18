package greensnow25.com.cyclicity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * public class CycleListTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.05.2017.
 */
public class CycleListTest {
    /**
     * class object.
     */
    private CycleList<String> list;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.list = new CycleList<>();
    }

    /**
     * test method hasCycle, if list have cycle, then return true.
     */
    @Test
    public void whenCallHasCycleAndListIsACycleThenReturnTrue() {
        this.createCycleList();
        assertTrue(list.hasCycle(list.getFirstNode()));
    }

    /**
     * test method hasCycle, if list have no cycle, then return false.
     */
    @Test
    public void whenCallHasCycleAndListIsANoCycleThenReturnTrue() {
        this.createNoCycleList();
        assertFalse(list.hasCycle(list.getFirstNode()));
    }

    /**
     * create list with out no cycle.
     */
    public void createNoCycleList() {
        this.list.addToNoCycle("1111");
        this.list.addToNoCycle("2222");
        this.list.addToNoCycle("3333");
        this.list.addToNoCycle("4444");
    }

    /**
     * create list with cycle.
     */
    public void createCycleList() {
        this.list.addToListWithCycle("1111");
        this.list.addToListWithCycle("2222");
        this.list.addToListWithCycle("3333");
        this.list.addToListWithCycle("4444");
    }
}