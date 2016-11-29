package array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;



public class TurnTest {
    @Test
    public void whenInputArraythenOutTurnArray()  {

        Turn turn = new Turn();                     //creating objeck turn of type Turn()
        int [] test={1,2,3,4,5,6,7};                // createing testiting array
        int [] expected ={7,6,5,4,3,2,1};           // creating expected array
        int [] line = turn.back(test);              // creating a line array and pass it to the method back ()

        assertThat(line, is (expected));


    }

}