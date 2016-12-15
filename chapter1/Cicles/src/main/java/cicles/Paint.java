package cicles;
/** Class Paint, turn array;
 * @author grensnow25;
 * @since 29.11.16;
 * @version 7;
 */


public class Paint {


 /*
   @ return зyramid of the symbols
  */
    String piramid(){

        StringBuilder sb = new StringBuilder(); // creating objeck of class Stringbuilder


        for (int i = 1; i<= 3; i++){                //create a loop to view column
            int  wieght = 2* 3 -1;                // integer variable that is equal to the length of the pyramid
            for (int j =1;j <=wieght; j++) {   //create a loop to view line

                if (j== 3 -i+1 || j== 3 +i-1 ){    //a condition where the insert symbol
                    sb.append("^");

                }

                 else
                    sb.append(" ");

            }
            sb.append("\r\n");                 //when the deadline for a newline

       }
        return sb.toString();




    }




}
