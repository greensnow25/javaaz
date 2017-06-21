package com.greensnow25.moneyTransfer;

import javax.jws.soap.SOAPBinding;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * public class UserStorage.
 *
 * @author greensnow25.
 * @version 1.
 * @since 21.06.2017.
 */
public class UserStorage {

    private HashMap<User, User> storage;

    private Map<Integer, UserOperations> operations;

    public UserStorage() {
        this.storage = new HashMap<>();
        this.operations = new TreeMap<>();
    }

    /**
     * add operations to the operation storage.
     */
    public void addOperations() {
        operations.put(1, new AddUser("1 - Add User to the storage"));
        operations.put(2, new RemoveUser("2 - Remove User from storage"));
        operations.put(3, new SetUser("3 - edit User, set amount equals 1000."));
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
     * print user name and balance.
     */
    public void printUserInfo() {
        Iterator<User> it = storage.values().iterator();
        while (it.hasNext()) {
            User user = it.next();
            System.out.printf("%s : %d%s", user.getName(), user.getAmount(), System.getProperty("line.separator"));
        }
    }

    public boolean transferMoney(User sender, User receiver, int amountOfMoney) throws Exception {
        synchronized (sender) {
            synchronized (receiver) {
                if (sender.getAmount() < amountOfMoney) {
                    System.out.println("Not enough money for translation");
                    return false;
                } else {
                    sender.setAmount(sender.getAmount() - amountOfMoney);
                    receiver.setAmount(receiver.getAmount() + amountOfMoney);
                    return true;
                }
            }
        }
    }

    private class AddUser extends UserOperations {
        public AddUser(String info) {
            super(info);
        }

        /**
         * add user to the storage.
         *
         * @param user
         * @return true if success.
         */
        @Override
        public boolean doSomething(User user) {
            synchronized (storage) {
                if (storage.containsKey(user)) {
                    return false;
                } else {
                    storage.put(user, user);
                    return true;
                }
            }
        }
    }

    private class RemoveUser extends UserOperations {
        public RemoveUser(String info) {
            super(info);
        }

        /**
         * remove user from storage.
         *
         * @param user user.
         * @return true is successful.
         */
        @Override
        public boolean doSomething(User user) {
            synchronized (storage) {
                if (storage.containsKey(user)) {
                    storage.remove(user);
                    return true;
                } else {
                    return false;
                }
            }
        }

    }

    private class SetUser extends UserOperations {
        public SetUser(String info) {
            super(info);
        }

        /**
         * @param user
         * @return
         */
        @Override
        public boolean doSomething(User user) {
            synchronized (storage) {
                if (storage.containsKey(user)) {
                    User userTmp = storage.get(user);
                    userTmp.setAmount(1000);
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
    public void run(){

    }


    public Map<Integer, UserOperations> getOperations() {
        return operations;
    }

    public static void main(String[] args) {
        UserStorage storage = new UserStorage();
}

}
