package array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * public class Turn.
 * @author greensow25.
 * @since 30.11.16.
 * @version 1.
 */


public class TurnTest {
    /**
     * method.
     */
    @Test
    public void whenInputArraythenOutTurnArray() {

        Turn turn = new Turn();
        final int[] test = {1, 2, 3, 4, 5, 6, 7};
        final int[] expected = {7, 6, 5, 4, 3, 2, 1};
        int[]line = turn.back(test);

        assertThat(line, is(expected));


    }

}