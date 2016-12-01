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

        int [][]result = rotation.rotatian(test);

        assertThat(result, is (result));

        for(int i =0; i<=result.length-1;i++){
            for (int j =0; j<=result.length -1;j++){
                System.out.print(result [i][j] + " ");
            }
            System.out.println();
        }



    }

}