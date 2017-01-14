package com.greensnow25.start;

import com.greensnow25.modules.Item;
import com.greensnow25.modules.Task;

import java.util.Arrays;
import java.util.Scanner;


/**
 *public class ConsoleInput displays a menu to the console and.
 * requests the user's actions.
 * @author greensnow25.
 * @since 10.01.17.
 * @version 1.
 */
public class StubInput  {
    /**
     * object of class Tracker.
     */
     Tracker tracker = new Tracker();
    /**
     * boolean variable to exit the application.
     */
    private boolean exit = true;
    Item item;
   Task[] tasks = new Task[10];
    Task task = new Task();

    int scanInt;
    int count;


    public StubInput(int scanInt, int count, String name, String description) {
        task.setName(name);
        task.setDiscription(description);
        this.scanInt = scanInt;
        this.count = count;
    }
    public StubInput (){

    }

    public StubInput(int scanInt, int count) {
        this.count = count;
        this.scanInt = scanInt;
    }
    public  StubInput(int scanInt){
        this.scanInt = scanInt;
    }
    /**
     *user welcome.
     */
    public void hello(StubInput stub) {

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

                if (scanInt == 1) {

                    if (count != tasks.length) {
                        tracker.add(task);
                        System.arraycopy(tracker.getItems(),0,tasks,0,10);
                        System.out.println("Заявка создана");
                        System.out.println(tasks[count-1].getName() + "   " + tasks[count-1].getDiscription());
                        System.out.println(tracker.getItems()[0].getName() + "   " + tracker.getItems()[0].getDiscription());
                        break;
                    }else {
                        System.out.println("Добавить заявку невозможно!");
                        break;
                    }
                } else if (scanInt == 2) {
                    String id = tasks[count-1].getId();
                     item = tracker.findById(id);
                    System.out.println("Bаша заявка:" + tasks[count-1].getName());
                } else if (scanInt == 3) {
                    tracker.getAll();
                    System.out.format("список");
                    break;
                } else if (scanInt == 4) {
                    String name = tasks[count-1].getName();
                     item = tracker.findByName(name);
                    String id = tasks[count-1].getId();
                    tasks[1].setId(id);
                    tracker.update(tasks[count]);
                    System.out.println("заявка обновлена.");
                } else if (scanInt == 5) {
                    String idDelede = tasks[count-1].getId();
                    tracker.delete(tracker.findById(idDelede));
                    System.out.println("Заявка " + idDelede + " удалена.");
                    count--;
                } else if (scanInt == 6) {
                    String name = tasks[count-1].getName();
                    item = tracker.findByName(name);
                    System.out.println("Заявка найдена : " + tasks[count-1].getName() +
                                        "  " + tasks[count-1].getDiscription());
                } else if (scanInt == 0) {
                    exit = false;
                }
            }


        }


   /** public static void main(String[] args) {
StubInput stub = new StubInput();
        stub.hello();

        stub.choise();

    }*/

}
