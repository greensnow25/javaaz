package com.greensnow25;

/**
 * public class Menu.
 *
 * @author greensnow25.
 * @version 1.
 * @since 29.03.2017.
 */

import com.greensnow25.Input.Input;
import com.greensnow25.Input.UserInput;

import java.util.ArrayList;
import java.util.Map;

/**
 * Создать меню.
 * Петр Арсентьев,  26.11.16 10:14  [#4748]
 * Реализовать структуру для поддержания меню.
 * <p>
 * Каждый элемент меню имеет имя. Все меню должно выводиться на экран.
 * <p>
 * Каждый пункт меню может быть как одиночным элементов, так и иметь дочерние под пункты.
 * <p>
 * Все меню должно выводиться на экран. В виде дерева.
 * <p>
 * Предусмотреть возможность определяет действие, когда пользователь выбрать конкретный пункт меню.
 * <p>
 * Например
 * <p>
 * Задача 1.
 * <p>
 * ---- Задача 1.1.
 * <p>
 * --------- Задача 1.1.1.
 * <p>
 * --------- Задача 1.1.2.
 * <p>
 * ----- Задача 1.2.
 */
public class Menu {
    /**
     * menu.
     */
    private ArrayList<ItemOnce> itemOnces;
    /**
     * Indent from left field.
     */
    private int len;
    /**
     * input system.
     */
    private Input input;


    public static void main(String[] args) {
        Menu menu = new Menu(new UserInput());
        menu.run();


    }

    /**
     * constructor.
     *
     * @param input input System.
     */
    public Menu(Input input) {
        this.itemOnces = new ArrayList<>();
        this.input = input;
    }

    /**
     * run application.
     */
    public void run() {
        this.addItem();
        String separator = System.getProperty("line.separator");
        System.out.printf("%s%s%s%s", "1-show menu", separator, "2-rename menu item", separator);
        String answer;
        do {
            answer = input.ask("Enter operation:");
            if (answer.equals("1")) {
                len = 0;
                print(itemOnces);
            } else if (answer.equals("2")) {
                String oldName = input.ask("Enter the menu item you want to rename");
                String newName = input.ask("Enter new name for item");
                rename(oldName, newName, this.itemOnces);
            }
        } while (!answer.equals("exit"));
    }

    /**
     * create menu.
     */
    public void addItem() {
        ItemOnce one = new ItemOnce("one");
        itemOnces.add(one);
        one.addItem("two1");
        one.addItem("two2");
        one.addItem("two3");

        one.getItems().get(0).addItem("one33");
        one.getItems().get(1).addItem("one3");

    }

    /**
     * print menu.
     *
     * @param itemOnce list menu.
     */
    public void print(ArrayList<ItemOnce> itemOnce) {
        String separator = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        for (ItemOnce item : itemOnce) {
            if (item != null) {
                for (int i = 0; i != len; i++) {
                    sb.append(" ");
                }
                System.out.printf("%s %s%s", sb.toString(), item.getName(), separator);
                if (item.getItems().size() != 0) {
                    len += item.getName().length();
                }
                sb.delete(0, sb.length());
                print(item.getItems());
            }
            if (item.getItems().size() == 0) {
                len -= item.getName().length();
            }
        }

    }

    /**
     * rename menu item.
     *
     * @param oldName name.
     * @param newName name.
     * @param list    menu list.
     */
    public void rename(String oldName, String newName, ArrayList<ItemOnce> list) {
        for (ItemOnce itemOnce : list) {
            if (itemOnce.getName().equals(oldName)) {
                itemOnce.rename(newName);
            } else {
                rename(oldName, newName, itemOnce.getItems());
            }
        }
    }

    /**
     * getMenu.
     *
     * @return menu.
     */
    public ArrayList<ItemOnce> getItemOnces() {
        return itemOnces;
    }
}








