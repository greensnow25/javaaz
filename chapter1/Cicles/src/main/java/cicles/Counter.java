package cicles;

/** Class Counter calculait sum on interval;
 * @author grensnow25;
 * @since 18.11.16;
 * @version 1;
 */
public class Counter {
   // method add return sum;

    public int add(int start, int finish){
         int sum=0;

        for (int i = start; i<= finish; i++){
        sum= sum+ i;

        }

            return sum;
    }
}
