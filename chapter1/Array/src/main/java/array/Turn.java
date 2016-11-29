package array;
/** Class Turn, turn array;
 * @author grensnow25;
 * @since 29.11.16;
 * @version 1;
 */


public class Turn {

//method takes an array and turns it
    public int []back(int line [] ) {

        int n = line.length/2;

             for (int i =0; i<n;i++) {

                int temp= line [line.length-i-1] ;
                line[line.length-i-1]= line [i];
                line [i]= temp;




                }return line ;

    }

}