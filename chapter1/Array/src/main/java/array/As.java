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

    public int[] sort(int[] one, int[] two) {
        int[] result = new int[one.length + two.length];
        int index = 0;
        int j = 0;
        int i = 0;

        while (j != two.length && i != one.length) {
            if (one[i] <= two[j]) {
                result[index++] = one[i++];

            } else if (two[j] <= one[i]) {
                result[index++] = two[j++];

            }
        }
        if (i < one.length) {
            System.arraycopy(one,i+1,result,index,one.length-i-1);

        }
        else if (j < two.length) {
            System.arraycopy(two,j+1,result,index+1,two.length-j);

        }


        return result;
    }
}

