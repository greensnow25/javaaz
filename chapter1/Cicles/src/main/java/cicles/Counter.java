package cicles;

/** Class Counter calculait sum on interval;
 * @author grensnow25;
 * @since 18.11.16;
 * @version 1;
 */
public class Counter {
   // method add return sum;

    public int add(){
         int sum=0;

        for (int i = 1; i<= 9; i++){
       if(i%2 == 0){ sum= sum+ i;}

        }

            return sum;
    }
}
