package array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * public class RemovingDuplicatesTest.
 * @author greensow25.
 * @since 30.11.16.
 * @version 1.
 */
 public class RemovingDuplicatesTest {
    /**
     *
     * method.
     */
     @Test
    public void whenEnterArraythenOutWithOutduplikats() {
        RemovingDuplicates remove = new RemovingDuplicates();
        String[] test = new String[]{"Привет", "Привет", "Мир", "Мир", "Меня", "Меня", "Зовут", "Александр", "Мир"};
        String[] expected = new String[]{"Привет", "Мир", "Меня", "Зовут", "Александр"};
        String[] result = remove.removd(test);
        assertThat(result, is(expected));

    }

}