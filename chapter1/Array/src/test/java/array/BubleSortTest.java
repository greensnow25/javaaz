package array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * public class BubleSort it sort array the method of buble.
 * @author greensow25.
 * @since 30.11.16.
 * @version 1.
 */

public class BubleSortTest {
    /**
     * method.
     */
    @Test
    public void whenEnterArraythenOutSortArray()  {

        BubleSort sort = new BubleSort();
        final int ar = 7;
        final int arr = 30;
        int[]testarray = new int[ar];
            for (int i = 0; i <= testarray.length - 1; i++) {
            testarray[i] = (int) (Math.random() * arr);
            }
        int[]expectedarray = sort.sort(testarray);
            assertThat(expectedarray, is(testarray));
    }

}