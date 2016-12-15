package cicles;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class FactorialTest {

    /*
    Testing return value;
     */

    @Test
    public void whenEnterParamInConstrthesShowFactorial(){
        Factorial fact = new Factorial();
        int factorial = fact.show();
        assertThat(factorial, is (362880));

    }


}