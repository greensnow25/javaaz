package array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class BubleSortTest {
    @Test
    public void whenEnterArraythenOutSortArray()  {

        BubleSort sort = new BubleSort();
        int [] testarray= new int[7];
            for (int i =0; i<=testarray.length-1;i++){
            testarray[i]=(int) (Math. random()*30);

            }
        int [] expectedarray= sort.sort(testarray);
            assertThat(expectedarray, is (testarray));
    }

}