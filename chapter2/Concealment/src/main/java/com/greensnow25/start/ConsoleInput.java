package com.greensnow25.start;

import com.greensnow25.modules.Item;
import com.greensnow25.modules.Task;
import com.greensnow25.start.Tracker;
import java.util.Scanner;

/**
 *
 */
public class ConsoleInput extends Tracker implements Input{

    private Tracker tracker;

    private Task task;
    ConsoleInput[] consoleInputs = new ConsoleInput[10];
    public Scanner scan = new Scanner(System.in);

    public void hello(){
        System.out.println("1 - Добавить заявку.");
        System.out.println("2 - Найти заявку по id");
        System.out.println("3 - Показать все заявки.");
        System.out.println("4 - Обновить заявку.");
        System.out.println("5 - Удалить заявку.");
        System.out.println("6 - Найти заявку по имени.");
    }


    public void choise() {
      consoleInputs[0] = tracker.add(task);

       // consoleInput[1] = tracker.findById(task.getId());
       // consoleInput[2] = tracker.getAll();
      // consoleInput[3] = tracker.update(task);
       // consoleInput[4] = tracker.delete();
       // consoleInput[5] = tracker.findByName(task.getName());

    }

    @Override
    public String ask(String qestion) {
        return qestion;
    }
}
