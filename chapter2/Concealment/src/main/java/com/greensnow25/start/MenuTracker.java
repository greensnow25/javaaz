package com.greensnow25.start;

import com.greensnow25.modules.Item;
import com.greensnow25.modules.Task;

/**
 * public class MenuTracker.
 * contein inner classes whos perfoms actions from then.
 *@author greensnow 25.
 * @since 19.01.17.
 * @version 1.
 */
public class MenuTracker {
    /**
     * class object.
     */
    private Input input;
    /**
     * class object.
     */
    private Tracker tracker;
    /**
     * array of abjects.
     */
    private UserAction[] userActions = new UserAction[6];

    /**
     * class constructor.
     * @param input class object.
     * @param tracker class object.
     */
    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * filling array objects with help inner clases.
     */
    public  void filling() {
        userActions[0] = new AddItem();
        userActions[1] = this.new FindById();
        userActions[2] = this.new ShowAll();
        userActions[3] = this.new UpdateItem();
        userActions[4] = this.new DeleteItem();
        userActions[5] = this.new FindByName();
    }

    /**
     * method perfom actions with items.
     * @param key action number.
     */
    public void select(int key) {
        this.userActions[key].execute(input, tracker);
    }

    /**
     *method collect informstiom from inner classes.
     */
    public void show() {
        for (UserAction useractions : userActions) {
            if (useractions != null) {
                System.out.println(useractions.info());
            }
        }
    }

    /**
     * Inner class AddItem.
     * add Item.
     */
    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.add(new Task(input.ask("name"), input.ask("desk")));
            System.out.println("operation sucsesfull ");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the item.");
        }
    }

    /**
     * Inner class FindById
     * find item by id.
     */
    private class FindById implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
             Item item = tracker.findById(input.ask("enter id"));
            System.out.format("%s  %s", "operation sucsesfull name "
                     + item.getName(), "desk " + item.getDiscription() + System.getProperty("line.separator"));

        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by id.");
        }
    }

    /**
     * Inner class ShowAll.
     * show all items.
     */
    private class ShowAll implements UserAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.getAll();
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show items .");
        }
    }

    /**
     * Inner class UpdateItem.
     * class update item
     */
    private class UpdateItem implements UserAction {
        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findByName(input.ask("\n"
                    + "enter the name of the application you will edit : "));
            item.getId();
            Task task = new Task(input.ask("new name"), input.ask("new desk"));
            task.setId(item.getId());
            tracker.update(task);
            System.out.println("operation sucsesfull ");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item.");
        }
    }

    /**
     * Inner class DeleteItem/
     * delete the item.
     */
    private class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findByName(input.ask(
                        "Enter item mane whos will be delete: "));
            tracker.delete(item);
            System.out.println("operation sucsesfull ");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }
    }

    /**
     * Inner class FindByName.
     * find item be name.
     */
    private  class FindByName implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findByName(input.ask("enter the name : "));
            System.out.format("%s  %s", "operation sucsesfull name "
                   + item.getName(), "desk " + item.getDiscription() + System.getProperty("line.separator"));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by name: ");
        }
    }
}

