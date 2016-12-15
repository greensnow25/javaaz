package array;
/**
*public class RemovingDuplicates removes duplicates from array.
*@author greensnov 25.
*@since 08.12.16.
*@version 3.0.
 */

public class RemovingDuplicates {
    /**
     * method removd.
     * @param words line.
     * @return array with out duplicats.
     */

    final String[] removd(final String[] words) {
        int count = 0;
           for (int i = 0; i < words.length - 1; i++) {
                for (int j = i  + 1; j <= words.length - 1; j++) {
                     if (words[i] != null && words[j] != null
                             && words[i].equals(words[j])) {
                         words[j] = null;
                         count++;
                     }
                 }
            }
          String[] small = new String[words.length - count];
                    count = 0;
                for (int i = 0; i <= words.length - 1; i++) {

                        if (words[i] != null) {
                            small[count++] = words[i];

                   }
                }
        return small;
    }






}
