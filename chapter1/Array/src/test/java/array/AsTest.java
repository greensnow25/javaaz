package array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * public class AsTest unites two sorted arrays.
 * @author greensnow25.
 * @since 02.01.17.
 * @version 1.0.
 */
public class AsTest {
    /**
     * method test returned unites array.
     */
    @Test
    public void whenTwoSortedArraysThenReturnUnitesArray()  {
        As as = new As();
        final int[] arrayOne = new int[]{1, 2, 4, 6, 8};
        final int[] arrayTwo = new int[] {2, 3, 5, 7, 9};
        final int[] unitArray = new int[]{1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        final int[] result = as.sort(arrayOne, arrayTwo);
        assertThat(result, is(unitArray));
    }

}