/*Создать программу проверяющую, что строка sub является подстрокой origin.
        boolean contains(String origin, String sub).
        Нельзя использовать String.indexOf String.contains.
        Нужно преобразовать строку в массив символов и проверить.
*/
package array;

import java.util.Arrays;

/**
 * public class Contain chec for sub on origin.
 * @author greensnow25.
 * @since 13.12.16.
 * @version 1.
 */
public class Contain {
    /**
     *
     * @param origin line.
     * @param sub line.
     * @return boolean result.
     */
   final boolean contains(final String origin, final String sub) {
       char[] words = origin.toCharArray();         //разбиваем оригинальную строку на символы
        char[] small = sub.toCharArray();           // разбиваем подстроку на символы
        int smallLenngth = small.length;            // узнаем длинну подстроки
        boolean result = true;
       int count = 0;                               // счетчик совпадений
       for (int i = 0; i <= words.length - 1; i++) { //просматриваем оригинальную строку
           if (words[i] == small[0]) {                  // если первая буква строки и подстроки равны
               char[] cop = Arrays.copyOfRange(words, i, i+smallLenngth); // копируем в новый массив с промежутком равным длинне подстроки
               for (int j = 0; j <= cop.length - 1; j++) { // просматриваем скопированый массив
                         if (cop[j] == small[j]) {          // если символы равны
                            count++;                        // увеичиваем счетчик на 1
                             if (count == smallLenngth-1) {  // если количество совпадений равно количеству символов подстроки
                                result = false;               // выводим результат , что совпадения найдены
                                count = 0;                    // обнуляем счетчик
                             }




                         }
                      }
           }

       }

       return result;
   }


}
