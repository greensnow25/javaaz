package com.greensnow25;

/**
 * public class Menu.
 *
 * @author greensnow25.
 * @version 1.
 * @since 29.03.2017.
 */

import java.util.regex.Pattern;

/**
 * Создать меню.
 Петр Арсентьев,  26.11.16 10:14  [#4748]
 Реализовать структуру для поддержания меню.

 Каждый элемент меню имеет имя. Все меню должно выводиться на экран.

 Каждый пункт меню может быть как одиночным элементов, так и иметь дочерние под пункты.

 Все меню должно выводиться на экран. В виде дерева.

 Предусмотреть возможность определяет действие, когда пользователь выбрать конкретный пункт меню.

 Например

 Задача 1.

 ---- Задача 1.1.

 --------- Задача 1.1.1.

 --------- Задача 1.1.2.

 ----- Задача 1.2.
 */
public class Menu {

private String[] names = new String[]{"name 1.", "name 2.", "name 2.1.", "name 1.1.", "name1.1.1.","name1.1.1.1.", "name1.2.1."};


public void showMenu(){

}

public String[] sortArray(String[] names){
    Pattern pattern = Pattern.compile("w");



    return names;
}


}
