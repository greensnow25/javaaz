package cicles;
/*
public class Factorial= calculate factorial
 * @author greensnow25 ;
 * @sinse 15.11.16;
 * @version 1;
 */

public class Factorial {

    /*
     * public methoh show calculate integer factorial;
     * @return value - fac
    */
    public int show(int x){
       int fac=x;

        for ( x=x-1; x>0; x--) {

            fac =fac * x;
        }
       return fac;
    }
  

}

