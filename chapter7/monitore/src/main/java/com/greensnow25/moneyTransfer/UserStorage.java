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

    private HashMap<String, User> storage;

    private Map<Integer, UserOperations> operations;

    Input input;

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
    }

    /**
     * select operation
     *
     * @param key key of operation.
     * @return true if successful.
     */
    public boolean select(int key) {
        return operations.get(key).doSomething();
    }


    public boolean transferMoney(User sender, User receiver, int amountOfMoney) throws Exception {
        if (!storage.containsKey(sender) || !storage.containsKey(receiver)) {
            System.out.println("Does not exist.");
            return false;
        } else if (sender.getAmount() < amountOfMoney) {
            System.out.println("Not enough money for translation");
            return false;
        }

        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (sender) {
                    sender.setAmount(sender.getAmount() - amountOfMoney);
                }
            }
        });
        Thread two = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (receiver) {
                    receiver.setAmount(receiver.getAmount() + amountOfMoney);
                }
            }
        });

        one.start();
        two.start();
        return true;
//        synchronized (sender) {
//            synchronized (receiver) {
//                if (sender.getAmount() < amountOfMoney) {
//                    System.out.println("Not enough money for translation");
//                    return false;
//                } else {
//                    sender.setAmount(sender.getAmount() - amountOfMoney);
//                    receiver.setAmount(receiver.getAmount() + amountOfMoney);
//                    return true;
//                }
//            }
//        }
    }

    private class AddUser extends UserOperations {
        public AddUser(String info, int key) {
            super(info, key);
        }

        /**
         * add user to the storage.
         *
         * @param user
         * @return true if success.
         */
        @Override
        public boolean doSomething() {
            synchronized (input) {
                String name = input.ask("Enter the name");
                int amount = Integer.parseInt(input.ask("Enter the amount of money in your account"));
                synchronized (storage) {
                    if (storage.containsKey(name)) {
                        return false;
                    } else {
                        storage.put(name, new User(name, amount));
                        return true;
                    }
                }
            }
        }
    }

    private class RemoveUser extends UserOperations {
        public RemoveUser(String info, int key) {
            super(info, key);
        }

        /**
         * remove user from storage.
         *
         * @param user user.
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

    private class SetUser extends UserOperations {
        public SetUser(String info, int key) {
            super(info, key);
        }

        /**
         * @param user
         * @return
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

    private class ShowUsers extends UserOperations {

        public ShowUsers(String info, int key) {
            super(info, key);
        }

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

    public void runOperations() {

        String answer;
        this.addOperations();
        this.printInfo();
        while (true) {
            answer = input.ask("Make a choice: ");
            if (answer.equals("exit")) break;
            this.select(Integer.parseInt(answer));
        }

    }


    public Map<Integer, UserOperations> getOperations() {
        return operations;
    }

    public static void main(String[] args) {
        UserStorage storage = new UserStorage();
        storage.runOperations();
    }

}
