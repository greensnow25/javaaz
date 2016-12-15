package array;
/**
 * public class RotationArray rotait square array.
 * @author greensnow25.
 * @since 30.11.2016.
 * @version 1.
 */

public class RotationArray {

    /**
     *  method rotait array.
     * @param square array.
     * @return rotait array.
     */

   final int[][]rotatian(final int[][]square) {

       int[][] result = new int[square.length][square.length];

      for (int i = 0; i <= square.length - 1; i++) {
          for (int j = 0; j <= square.length - 1; j++) {
               result [j][i] = square [square.length -  1 - i][j];

          }
      }
       return result;
   }
}
