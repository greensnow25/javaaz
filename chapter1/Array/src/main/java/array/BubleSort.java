package array;
/**
 * public class BubleSort it sort array the method of buble.
 * @author greensow25.
 * @since 30.11.16.
 * @version 1.
 */

public class BubleSort {
    /**
     *
     * @param array int.
     * @return sort array.
     */
    final int[] sort(final int[] array) {

        for (int i = 0; i <= array.length - 1; i++) {

            for (int j = i + 1; j <= array.length - 1; j++) {

                if (array [i] >= array[j]) {

                    int temp = array[i];
                    array [i] = array [j];
                    array [j] = temp;
                }

            }

        }
        return array;
    }


}
