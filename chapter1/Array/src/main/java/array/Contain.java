/*Создать программу проверяющую, что строка sub является подстрокой origin.
        boolean contains(String origin, String sub).
        Нельзя использовать String.indexOf String.contains.
        Нужно преобразовать строку в массив символов и проверить.
*/
package array;

/**
 * public class Contain chec for sub on origin.
 *
 * @author greensnow25.
 * @version 1.
 * @since 13.12.16.
 */
public class Contain {
    /**
     * @param origin line.
     * @param sub    line.
     * @return boolean result.
     */
    final boolean contains(final String origin, final String sub) {
        char[] words = origin.toCharArray();
        char[] small = sub.toCharArray();
        boolean result = true;
        int count = 0;
        for (int i = 0; i <= words.length - 1; i++) {
            if (words[i] == small[0]) {

                for (int j = 0; j <= small.length - 1; j++) {
                    if (words[j] == small[j]) {
                        count++;
                        if (count == small.length) {
                            result = false;
                            count = 0;
                        }
                    }
                }
            }
        }
        return result;
    }
}
