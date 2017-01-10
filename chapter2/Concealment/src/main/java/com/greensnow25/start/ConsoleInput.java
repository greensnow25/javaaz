package com.greensnow25.start;

import com.greensnow25.modules.Item;
import com.greensnow25.modules.Task;
import java.util.Scanner;

/**
 *public class ConsoleInput displays a menu to the console and.
 * requests the user's actions.
 * @author greensnow25.
 * @since 10.01.17.
 * @version 1.
 */
public class ConsoleInput {
    /**
     * object of class Tracker.
     */
      private Tracker tracker = new Tracker();
    /**
     * boolean variable to exit the application.
     */
       private boolean exit = true;

    /**
     * reads the data entered from the console.
     */
    private Scanner scan = new Scanner(System.in);

    /**
     *user welcome.
     */
    public void hello() {
        System.out.println("1 - Добавить заявку.");
        System.out.println("2 - Найти заявку по id");
        System.out.println("3 - Показать все заявки.");
        System.out.println("4 - Обновить заявку.");
        System.out.println("5 - Удалить заявку.");
        System.out.println("6 - Найти заявку по имени.");
        System.out.println("0 - выход из приложения");
        System.out.println("введите желаемое действие");
    }

    /**
     * public method choise() displays a menu to the console and.
     * requests the user's actions.
     */

    public void choise() {

        while (exit) {

           hello();
           int scanInt = scan.nextInt();
           if (scanInt == 1) {
               System.out.println("Введите имя и описание заявки");
               tracker.add(new Task(scan.next(), scan.next()));
           } else if (scanInt == 2) {
              Item item = tracker.findById(scan.next());
              System.out.println("Bаша заявка:" + item.getName());
           } else if (scanInt == 3) {
               tracker.getAll();
           } else if (scanInt == 4) {
              System.out.println("Введите имя заявку, которую хотите обновить");
               Item item = tracker.findByName(scan.next());
              String id = item.getId();
               System.out.println("Введите новое имя и описание редактируемой заявки  заявки");
              Item itemOne = new Item(scan.next(), scan.next());
              itemOne.setId(id);
               tracker.update(itemOne);
           } else if (scanInt == 5) {
               String nameDelede = scan.next();
               tracker.delete(tracker.findByName(nameDelede));
               System.out.println("Заявка " + nameDelede + " удалена.");
           } else if (scanInt == 6) {
               Item item = tracker.findByName(scan.next());
               System.out.println( "Заявка найдена : " + item.getName() + "  " + item.getDiscription());
           } else if (scanInt == 0) {
               exit = false;
           }
       }

    }


}
