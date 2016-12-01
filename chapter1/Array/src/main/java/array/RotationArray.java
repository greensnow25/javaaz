package array;
/*public class RotationArray rotait square array
@author greensnow25;
@since 30.11.2016;
@version 1;

 */


public class RotationArray {

 /*
 Public method rotatian (int [][] squre) rotait square array
 @return rotait aray
  */

   public int [][] rotatian (int [][] square){

       int [][] result = new int[square.length][square.length];      // create an array that stores the results

      for (int i =0;i<=square.length-1;i++){                         // view array
          for (int j =0; j<=square.length-1;j++){


               result [j][i] = square [square.length -1-i][j];     // condition of araay rotation

          }
      }

       return result ;
   }


    public static void main (String [] args){

        RotationArray rotation = new RotationArray();

    }
}
