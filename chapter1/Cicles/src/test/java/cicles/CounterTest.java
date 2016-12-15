package cicles;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class CounterTest {

   //Testing method of class;

    @Test
    public void whenEnterIntervalthenReturnSum() {
        Counter count = new Counter();
        int coun = count.add();
        assertThat(coun, is (20) );

    }

}