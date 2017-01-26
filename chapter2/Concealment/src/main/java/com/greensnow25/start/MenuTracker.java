package com.greensnow25.start;

import com.greensnow25.modules.Item;
import com.greensnow25.modules.Task;

/**
 * public class MenuTracker.
 * contein inner classes whos perfoms actions from then.
 *
 * @author greensnow 25.
 * @version 1.
 * @since 19.01.17.
 */
public class MenuTracker {
    /**
     * array of keys from classes.
      */
    private int[] range = new int[7];
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
    private UserAction[] userActions = new UserAction[7];

    /**
     * class constructor.
     *
     * @param input   class object.
     * @param tracker class object.
     */
    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * filling array objects with help inner clases.
     */
    public void filling() {
        userActions[0] = this.new AddItem();
        userActions[1] = this.new FindById();
        userActions[2] = this.new ShowAll();
        userActions[3] = this.new UpdateItem();
        userActions[4] = this.new DeleteItem();
        userActions[5] = this.new FindByName();
        userActions[6] = this.new AddComment();
    }

    /**
     * method perfom actions with items.
     *
     * @param key action number.
     */
    public void select(int key) {
        this.userActions[key].execute(input, tracker);
    }

    /**
     * mehod write keys from classes in to array.
     */
    public void showkeys() {
        int position = 0;
       for (int index = 0; index < userActions.length; index++) {
            if (userActions[index] != null) {
                this.range[position++] = userActions[index].key();
           }
        }
    }
    /**
     * method collect informstiom from inner classes.
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

            try {
                Item item = tracker.add(new Task(input.ask("name"), input.ask("desk")));
                item.getComments().addComent(input.ask("Enter new comment:"));
                System.out.println("operation sucsesfull ");

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("an array of filled application form please delete item");
            }
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
            try {
                Item item = tracker.findById(input.ask("enter id"));
                String sep = System.getProperty("line.separator");
                System.out.format("%s %s", "operation sucsesfull " + sep + "name "
                        + item.getName(), "desk " + item.getDiscription() + sep);
            } catch (NullPointerException e) {
                System.out.println("Item with indicate id does not exist. Enter corect id.");
            }
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
            String sep = System.getProperty("line.separator");
            for (Item item : tracker.getAll()) {
                System.out.println("NAME  DESCRIPTION      ID    ");
                System.out.format("%s  %s  %s  %s", item.getName(), item.getDiscription(),
                        item.getId(), sep);
                System.out.println("COMMENTS LIST :");
                for (int index = 0; index != item.getComments().show().length; index++) {
                    System.out.format("%s  %s", item.getComments().show()[index], sep);
                }
            }
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
            try {
                Item item = tracker.findByName(input.ask("\n"
                        + "enter the name of the application you will edit : "));
                item.getId();
                Task task = new Task(input.ask("new name"), input.ask("new desk"));
                task.setId(item.getId());
                tracker.update(task);
                System.out.println("operation sucsesfull ");
            } catch (NullPointerException e) {
                System.out.println("Item with indicate name does not exist. Enter corect name.");
            }
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
            try {
                Item item = tracker.findByName(input.ask(
                        "Enter item mane whos will be delete: "));
                if (item != null) {
                    tracker.delete(item);
                    System.out.println("operation sucsesfull ");
                } else {
                    System.out.println("Item does not exist.");
                }
            } catch (NullPointerException e) {
                System.out.println("Item with indicate name does not exist. Enter corect name.");
            }
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
    private class FindByName implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            try {
                Item item = tracker.findByName(input.ask("enter the name : "));
                String sep = System.getProperty("line.separator");
                System.out.format("%s %s %s %s %s %s %s", "operation sucsesfull", sep,
                        "name ", item.getName(), "desk ", item.getDiscription(), sep);
            } catch (NullPointerException e) {
                System.out.println("Item with indicate name does not exist. Enter corect name.");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by name: ");
        }
    }

    /**
     * public class AddComment
     * add a comment to an existing application.
     */
    public class AddComment implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            try {
                Item item = tracker.findByName(input.ask("name"));
                item.getComments().addComent(input.ask("enter new comment"));

            } catch (NullPointerException e) {
                System.out.println("Item with indicate name does not exist. Enter corect name.");
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "add the comment");
        }
    }

    /**
     * get range.
     * @return array of keys from classes.
     */
    public int[] getRange() {
        return range;
    }
}

