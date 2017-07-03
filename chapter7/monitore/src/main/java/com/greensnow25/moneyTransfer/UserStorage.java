package com.greensnow25.moneyTransfer;

import java.util.*;

/**
 * public class UserStorage.
 *
 * @author greensnow25.
 * @version 1.
 * @since 21.06.2017.
 */
public class UserStorage {
    /**
     * users storage.
     */
    private HashMap<String, User> storage;
    /**
     * storage operations on users.
     */
    private Map<Integer, UserOperations> operations;
    /**
     * keyboard input.
     */
    private Input input;

    /**
     * constructor.
     */
    public UserStorage() {
        this.storage = new HashMap<>();
        this.operations = new TreeMap<>();
        this.input = new Input();
    }

    /**
     * add operations to the operation storage.
     */
    public void addOperations() {
        operations.put(1, new AddUser("1 - Add User to the storage", 1));
        operations.put(2, new RemoveUser("2 - Remove User from storage", 2));
        operations.put(3, new SetUser("3 - edit User, set new amount.", 3));
        operations.put(4, new ShowUsers("4 - Show Users info", 4));
    }

    /**
     * print info.
     */
    public void printInfo() {
        Iterator<UserOperations> it = operations.values().iterator();
        while (it.hasNext()) {
            it.next().info();
        }
        System.out.println("\"transfer\" - money transfer");
    }

    /**
     * select operation
     *
     * @param key key of operation.
     * @return true if successful.
     */
    public boolean select(String key) {
        boolean res = false;
        try {
            if (key.equals("transfer")) {
                String nameSender = input.ask("Enter user sender name : ");
                String nameReceiver = input.ask("Enter user receiver name : ");
                if (storage.containsKey(nameSender) && storage.containsKey(nameReceiver)) {
                    res = this.transferMoney(storage.get(nameSender)
                            , storage.get(nameReceiver)
                            , Integer.parseInt(input.ask("transfer amount")));
                }

            } else {
                res = operations.get(Integer.parseInt(key)).doSomething();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid data entry, try again:");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Method transfers money from one user's account to another.
     *
     * @param sender        sender.
     * @param receiver      receiver.
     * @param amountOfMoney amount of money.
     * @return true if successful.
     * @throws Exception Invalid data entry.
     */
    public synchronized boolean transferMoney(User sender, User receiver, int amountOfMoney) throws Exception {
        if (!storage.containsKey(sender.getName()) || !storage.containsKey(receiver.getName())) {
            System.out.println("Does not exist.");
            return false;
        } else if (sender.getAmount() < amountOfMoney) {
            System.out.println("Not enough money for translation");
            return false;
        } else {
            sender.setAmount(sender.getAmount() - amountOfMoney);
            receiver.setAmount(receiver.getAmount() + amountOfMoney);
            Thread.sleep(15000);
        }

        return true;
    }

    /**
     * inner class add user to storage.
     */
    private class AddUser extends UserOperations {

        public AddUser(String info, int key) {
            super(info, key);
        }

        /**
         * add user to the storage.
         *
         * @return true if success.
         */
        @Override
        public boolean doSomething() {
            synchronized (input) {
                String name = input.ask("Enter the name");
                int amount = Integer.parseInt(input.ask("Enter the amount of money in your account"));
                synchronized (storage) {
                    if (storage.containsKey(name)) {
                        System.out.println("User already exist.");
                        return false;
                    } else {
                        storage.put(name, new User(name, amount));
                        return true;
                    }
                }
            }
        }
    }

    /**
     * inner class remove user.
     */
    private class RemoveUser extends UserOperations {
        public RemoveUser(String info, int key) {
            super(info, key);
        }

        /**
         * remove user from storage.
         *
         * @return true is successful.
         */
        @Override
        public boolean doSomething() {
            synchronized (input) {
                System.out.println("Remove user.");
                String name = input.ask("Enter the name :");
                synchronized (storage) {
                    if (storage.containsKey(name)) {
                        storage.remove(name);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
    }

    /**
     * inner class Set user .
     */
    private class SetUser extends UserOperations {
        public SetUser(String info, int key) {
            super(info, key);
        }

        /**
         * set user in the storage.
         *
         * @return true is successful.
         */
        @Override
        public boolean doSomething() {
            synchronized (input) {
                String name = input.ask("Enter the name");
                int amount = Integer.parseInt(input.ask("Enter NEW amount of money in this account"));
                synchronized (storage) {
                    if (storage.containsKey(name)) {
                        User userTmp = storage.get(name);
                        userTmp.setAmount(amount);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
    }

    /**
     * inner class show all users.
     */
    private class ShowUsers extends UserOperations {
        public ShowUsers(String info, int key) {
            super(info, key);
        }

        /**
         * print users to the console.
         *
         * @return true.
         */
        @Override
        public boolean doSomething() {
            Iterator<User> it = storage.values().iterator();
            while (it.hasNext()) {
                User user = it.next();
                System.out.printf("%s : %d%s", user.getName(), user.getAmount(), System.getProperty("line.separator"));
            }
            return true;
        }
    }

    /**
     * run program.
     */
    public void run() {

        String answer;
        this.addOperations();
        this.printInfo();
        while (true) {
            answer = input.ask("Make a choice: ");
            if (answer.equals("exit")) break;
            this.select(answer);
        }
    }

    /**
     * psvm.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        UserStorage storage = new UserStorage();
        storage.run();
    }

}
