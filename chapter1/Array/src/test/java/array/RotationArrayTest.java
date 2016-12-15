package array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * public class RotationArray.
 * @author greensow25.
 * @since 30.11.16.
 * @version 1.
 */

public class RotationArrayTest {
    /**
     * method.
     */
    @Test
    public void whenPassTheArrayThenReturnRotaitArray() {
        RotationArray rotation = new RotationArray();
        final int[][]test =
                {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        final int[][]expected = {{7, 4, 1},
                        {8, 5, 2},
                        {9, 6, 3}};

        int[][]result = rotation.rotatian(test);

        assertThat(result, is(expected));

    }

}