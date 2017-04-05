package com.greensnow25.start;

import com.greensnow25.modules.Item;
import com.greensnow25.modules.Task;

import java.util.ArrayList;
import java.util.List;

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
    private List<BaseAction> userActions = new ArrayList<>();

    /**
     * array of keys from classes.
     */
    private List<Integer> range = new ArrayList<>(userActions.size());

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
        userActions.add(this.new AddItem("Add the item.", 0));
        userActions.add(this.new FindById("Find item by id.", 1));
        userActions.add(this.new ShowAll("Show items .", 2));
        userActions.add(this.new UpdateItem("Edit item.", 3));
        userActions.add(this.new DeleteItem("Delete item.", 4));
        userActions.add(this.new FindByName("Find item by name: ", 5));
        userActions.add(this.new AddComment("Add the comment", 6));
    }

    /**
     * method perfom actions with items.
     *
     * @param key action number.
     */
    public void select(int key) {
        this.userActions.get(key).execute(input, tracker);
    }

    /**
     * mehod write keys from classes in to array.
     */
    public void showkeys() {
        int position = 0;
        for (int index = 0; index < userActions.size(); index++) {
            if (userActions.get(index) != null) {
                this.range.add(position++,userActions.get(index).key());
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

    private class AddItem extends BaseAction {

        /**
         * constructor of class.
         *
         * @param name Information about what the class can do.
         * @param keyAction keyaction.
         */
        AddItem(String name, int keyAction) {
            super(name, keyAction);
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
    }

    /**
     * Inner class FindById
     * find item by id.
     */
    private class FindById extends BaseAction {

        /**
         * constructor of class.
         *
         * @param name Information about what the class can do.
         * @param keyAction keyaction.
         */
        FindById(String name, int keyAction) {
            super(name, keyAction);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("enter id"));
            String sep = System.getProperty("line.separator");
            System.out.format("%s %s", "operation sucsesfull " + sep + "name "
                    + item.getName(), "desk " + item.getDiscription() + sep);
        }
    }

    /**
     * Inner class ShowAll.
     * show all items.
     */
    private class ShowAll extends BaseAction {

        /**
         * constructor of class.
         *
         * @param name Information about what the class can do.
         * @param keyAction keyaction.
         */
        ShowAll(String name, int keyAction) {
            super(name, keyAction);
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
    }

    /**
     * Inner class UpdateItem.
     * class update item
     */
    private class UpdateItem extends BaseAction {
        /**
         * constructor of class.
         *
         * @param name Information about what the class can do.
         * @param keyAction keyaction.
         */
        UpdateItem(String name, int keyAction) {
            super(name, keyAction);
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
    }

    /**
     * Inner class DeleteItem/
     * delete the item.
     */
    private class DeleteItem extends BaseAction {

        /**
         * constructor of class.
         *
         * @param name Information about what the class can do.
         * @param keyAction keyaction.
         */
        DeleteItem(String name, int keyAction) {
            super(name, keyAction);
        }

        @Override
        public void execute(Input input, Tracker tracker) {

            Item item = tracker.findByName(input.ask(
                    "Enter item mane whos will be delete: "));
            if (item != null) {
                tracker.delete(item);
                System.out.println("operation sucsesfull ");
            } else {
                System.out.println("Item does not exist.");
            }
        }
    }

    /**
     * Inner class FindByName.
     * find item be name.
     */
    private class FindByName extends BaseAction {

        /**
         * constructor of class.
         *
         * @param name Information about what the class can do.
         * @param keyAction keyaction.
         */
        FindByName(String name, int keyAction) {
            super(name, keyAction);
        }

        @Override
        public void execute(Input input, Tracker tracker) {

            Item item = tracker.findByName(input.ask("enter the name : "));
            String sep = System.getProperty("line.separator");
            System.out.format("%s %s %s %s %s %s %s", "operation sucsesfull", sep,
                    "name ", item.getName(), "desk ", item.getDiscription(), sep);
        }
    }

    /**
     * public class AddComment
     * add a comment to an existing application.
     */
    public class AddComment extends BaseAction {

        /**
         * constructor of class.
         *
         * @param name Information about what the class can do.
         * @param keyAction keyaction.
         */
        AddComment(String name, int keyAction) {
            super(name, keyAction);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findByName(input.ask("name"));
            item.getComments().addComent(input.ask("enter new comment"));
        }

    }

    /**
     * get range.
     *
     * @return array of keys from classes.
     */
    public List<Integer> getRange() {
        return range;
    }
}

