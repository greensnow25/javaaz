package com.greensnow25.start;

import com.greensnow25.modules.Item;
import com.greensnow25.modules.Task;

/**
 * public class StartUI run TRACKER.
 * @author grensnow25.
 * @since 28.12.16.
 * @version 1.0.
 */
public class StartUI {
   private Input input;

    StartUI (Input input){
        this.input = input;
    }

    public void choise() {
        Tracker tracker = new Tracker();
        boolean exit = true;
        try  {
            while (exit) {
                hello();
                String action = input.ask("Что будем делать?");


                if (action.equals("1")) {
                    String askName = input.ask("Enter the name :");
                    String askDesk = input.ask("Enter the diskription : ");
                    tracker.add(new Task(askName, askDesk));
                    // break;
                } else if (action.equals("2")) {
                    String idName = input.ask("Введите ID заявки, которую хотите найти :");
                    Item item = tracker.findById(idName);
                    System.out.println("Bаша заявка:" + item.getName());
                } else if (action.equals("3")) {
                    tracker.getAll();
                } else if (action.equals("4")) {
                    String name = input.ask("Введите имя заявку, которую хотите обновить");
                    Item item = tracker.findByName(name);
                    String id = item.getId();
                    String newName = input.ask("Введите новое имя : ");
                    String newDisk = input.ask("Введите новое описание :");
                    Item itemOne = new Item(newName, newDisk);
                    itemOne.setId(id);
                    tracker.update(itemOne);
                } else if (action.equals("5")) {
                    String nameDelede = input.ask("Введите имя заявки, которую хотите удалить : ");
                    tracker.delete(tracker.findByName(nameDelede));
                    System.out.println("Заявка " + nameDelede + " удалена.");
                } else if (action.equals("6")) {
                    String name = input.ask("Введите имя заявки, которую необходимо найти : ");
                    Item item = tracker.findByName(name);
                    System.out.println("Заявка найдена : " + item.getName() + "  " + item.getDiscription());
                } else if (action.equals("0")) {
                    exit = false;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * method init run the aplication
     */
    public void init() {
/**
        String name = "123";
        String desk = "fdwe";
        int action = 1;
        Input sb = new StubInput(new String[]{name,desk});
   choise();*/
       ConsoleInput in = new ConsoleInput();


        choise();







    }
    /**
     * main.
     * @param args string array.
     */
    public static void main(String[] args) throws Exception {

        new StartUI(new ConsoleInput()).init();
    }
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
        //  System.out.println("введите желаемое действие");

    }

}
