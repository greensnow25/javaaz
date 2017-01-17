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
    /**
     * initialization.
     */
    private Input input;
    /**
     * initialization.
     */
    private Tracker tracker;
    /**
     * constructor of class.
     * @param input can be consol or emulation.
     * @param tracker add tracker.
     */
    StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * method performs actions with items.
     */
    public void choise() {

        boolean exit = true;
        String findId = "1";
        try  {
            while (exit) {

                String action = input.ask("Что будем делать?");

                if (action.equals("1")) {
                    String askName = input.ask("Enter the name :");
                    String askDesk = input.ask("Enter the diskription : ");
                    tracker.add(new Task(askName, askDesk));
                    System.out.println("Заявка " + tracker.findByName(askName).getName() + " добавлена");
                } else if (action.equals("2")) {
                    String idName = input.ask("Введите ID заявки, которую хотите найти :");
                    if (findId.equals(idName)) {
                        Item item = tracker.findById(idName);
                        System.out.println("Bаша заявка:" + item.getName());
                    } else {
                        System.out.println("Ваша заявка не найдена");
                    }
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
     * method init run the aplication.
     */
    public void init() {
        hello();
        choise();
    }
    /**
     * main.
     * @param args string array.
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "sada", "asd", "0"});
        new StartUI(input, tracker).init();
    }
    /**
     *user welcome.
     */

    public void hello() {

        System.out.println("1 - Добавить заявку.\r\n"
                         + "2 - Найти заявку по id\r\n"
                         + "3 - Показать все заявки.\r\n"
                         + "4 - Обновить заявку.\r\n"
                         + "5 - Удалить заявку.\r\n"
                         + "6 - Найти заявку по имени.\r\n"
                         + "0 - выход из приложения");


    }

}
