package array;

/**
 * public class As fsotiation arrays.
 * @author greensnow25.
 * @since 2.01.17.
 * @version 1.0.
 */

public class As {
    /**
     * final method unites two arrays.
     * @param one array.
     * @param two array.
     * @return unit array.
     */

    final int[] sort(int[] one, int[] two) {
        int[] result = new int[one.length + two.length];
        int index = 0;
        int j = 0;
        int i = 0;

        while (j <= two.length - 1 && i <= one.length - 1) {
            if (one[i] < two[j]) {
                result[index++] = one[i];
                i++;
            } else if (two[j] < one[i]) {
                result[index++] = two[j];
                j++;
            }
        }
        while (i <= one.length - 1) {
            result[index++] = one[i];
            i++;
        }
        while (j <= two.length - 1) {
            result[index++] = two [j];
            j++;
        }
        return result;
    }
}

