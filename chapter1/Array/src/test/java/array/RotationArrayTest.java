package array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class RotationArrayTest {
    @Test
    public void whenPassTheArrayThenReturnRotaitArray()  {
        RotationArray rotation = new RotationArray();
        int [][] test = {{1,2,3},
                        {4,5,6},
                        {7,8,9}};

        int [][] expected = {{7,4,1},
                             {8,5,2},
                             {9,6,3 }};

        int [][]result = rotation.rotatian(test);

        assertThat(result, is (expected));

    }

}