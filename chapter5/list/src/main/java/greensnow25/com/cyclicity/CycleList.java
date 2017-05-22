package greensnow25.com.cyclicity;

import java.util.Iterator;

/**
 * public class Cyclisity.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.05.2017.
 */
public class CycleList<T> implements Iterable<T> {
    /**
     * first node.
     */
    private Node<T> firstNode;
    /**
     * last node.
     */
    private Node<T> lastNode;
    /**
     * list sile.
     */
    private int size = 0;

    /**
     * constructor.
     */
    public CycleList() {

    }

    /**
     * Adds a value to a list that does not have a cycle.
     *
     * @param value value to add.
     */
    public void addToNoCycle(T value) {
        Node<T> tmp = lastNode;
        Node<T> node = new Node<>(value, null);
        lastNode = node;
        if (firstNode == null) {
            firstNode = node;
        } else {
            tmp.next = null;
        }
        size++;

    }


    /**
     * Adds a value to a list that have a cycle.
     *
     * @param value value to add.
     */
    public void addToListWithCycle(T value) {
        Node<T> tmp = lastNode;
        Node<T> node = new Node<>(value, null);
        lastNode = node;
        if (firstNode == null) {
            firstNode = node;
        } else {
            tmp.next = null;
        }
        size++;
    }

    /**
     * check has list a cycle.
     *
     * @param first first Node.
     * @return true, if have cycle.
     */
    public boolean hasCycle(Node<T> first) {
        Iterator itOne =this.iterator();
        Iterator itTwo = this.iterator();
        try {
            while (true){
                T one = (T) itOne.next();
                T two = itTwo.

            }
            size = 0;
        }
    } catch(
    NullPointerException ex)

    {
        ex.printStackTrace();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pointer = 0;
            private int myPointer = 0;

            @Override
            public boolean hasNext() {
                return pointer > size;
            }

            @Override
            public T next() {
                Node tmp = null;
                if (pointer == 0) {
                    tmp = firstNode;
                } else {
                    tmp = tmp.next;
                }
                pointer++;
                return (T) tmp.value;
            }

            public T myNext() {
                Node tmp = null;
                if (myPointer == 0) {
                    tmp = firstNode;
                    myPointer++;
                }
                for (int i = myPointer; ; i++) {
                    tmp = tmp.next;
                    myPointer++;
                    if (tmp == null) {
                        tmp = firstNode.next;
                        myPointer = 0;
                    } else if (myPointer % 2 == 0) {
                        return (T) tmp.value;
                    }
                }
            }
        };
    }


    /**
     * public class Node.
     *
     * @author greensnow25.
     * @version 1.
     * @since 18.05.2017.
     */
    private class Node<T> {
        /**
         * Value.
         */
        private T value;
        /**
         * Link to next node.
         */
        private Node<T> next;

        /**
         * constructor.
         *
         * @param value T value.
         * @param next  link to next Node.
         */
        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

    }
}
