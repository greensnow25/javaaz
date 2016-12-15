package array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Public class Contain checks the origin in the sub line.
 * @author greensnow25.
 * @since 15.12.16.
 * @version  2.
 */
public class ContainTest {
    /**
     * Method contain checks the origin in the sub line.
     */
    @Test
    public void contains()  {
        Contain con = new Contain();
        String origin = "Александр Нежельский";
        String sub = "Александр";
        boolean expected = false;
        boolean res = con.contains(origin, sub);
        assertThat(res, is(expected));

    }

}