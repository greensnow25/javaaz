package array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

 public class RemovingDuplicatesTest {
    @Test
    public void whenEnterArraythenOutWithOutduplikats() throws Exception {
        RemovingDuplicates remove = new RemovingDuplicates();
        String[] test = new String  []{"Привет", "Привет", "Мир", "Мир", "Меня", "Меня","Зовут", "Александр", "Мир"};
        String [] expected = new String[]{"Привет", "Мир", "Меня", "Зовут", "Александр"};
        String [] result = remove.removd(test);
        assertThat(result, is(expected));

    }

}