package com.greensnow25.threadSafe;

import java.util.Iterator;

/**
 * Public class ThreadSafeLinkedList.
 *
 * @author greensnow25.
 * @version 1.
 * @since 04.07.2017.
 */
public class ThreadSafeLinkedList<T> implements SimpleContainer<T> {


    /**
     * the first element of a given sequence.
     */
    private Node<T> firstItem;
    /**
     * the last element of a given sequence.
     */
    private Node<T> lastItem;
    /**
     * size of list.
     */
    int size = 0;

    /**
     * constructor.
     * <p>
     * initialize the fields where the first and last item refer to each other.
     */
    public ThreadSafeLinkedList() {
//        this.lastItem = this.new Node<T>(this.firstItem, null, null);
//        this.firstItem = new Node<T>(null, null, this.lastItem);
    }

    /**
     * add node to the list.
     *
     * @param t node.
     */
    @Override
    public synchronized void add(T t) {
        Node<T> prev = this.lastItem;
        Node<T> newNode = new Node<>(prev, t, null);
        lastItem = newNode;
        if (prev == null) {
            this.firstItem = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }

    /**
     * get node by index.
     *
     * @param index in the container.
     * @return node.
     */
    @Override
    public synchronized T get(int index) {
        Node<T> node = firstItem;
        for (int i = 0; i != index; i++) {
            node = this.returnCurrentItem(node);
        }
        return node.current;
    }

    /**
     * Method returns a reference to the next element.
     *
     * @param node curent node.
     * @return node.
     */
    private Node<T> returnCurrentItem(Node<T> node) {
        return node.next;

    }

    /**
     * remove first element.
     *
     * @return removable item.
     */
    public synchronized T removeFirst() {
        Node<T> node = firstItem.next;
        T res = firstItem.current;
        firstItem = node;
        node.previous = this.lastItem;
        this.size--;
        return res;
    }

    /**
     * remove last element.
     *
     * @return removable item.
     */
    public synchronized T removeLast() {
        Node<T> node = this.lastItem.previous;
        T res = lastItem.current;
        lastItem = node;
        node.next = this.firstItem;
        this.size--;
        return res;
    }

    /**
     * method return new object of Iterator.
     *
     * @return Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            private Node<T> node = null;

            /**
             * check, does next element exist.
             *
             * @return if exist , return true.
             */
            @Override
            public synchronized boolean hasNext() {
                return index < size;
            }

            /**
             * return next node from a given sequence,.
             * if no more nodes return NPE.
             *
             * @return node.
             */
            @Override
            public synchronized T next() {

                if(index == 0){
                    node = firstItem;
                }else {
                    node = node.next;
                }
                index++;
                return node.current;
            }
        };
    }


    public Node<T> getFirstItem() {
        return firstItem;
    }

    public Node<T> getLastItem() {
        return lastItem;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    /**
     * public class Node.
     *
     * @author greensnow25.
     * @version 1.
     * @since 16.05.2017.
     */
    private class Node<T> {
        /**
         * current element.
         */
        private volatile T current;
        /**
         * next element.
         */
        private volatile Node<T> next;
        /**
         * previous element.
         */
        private volatile Node<T> previous;

        /**
         * constructor.
         *
         * @param prev    previous element.
         * @param element current element.
         * @param next    next element.
         */
        public Node(Node<T> prev, T element, Node<T> next) {
            this.current = element;
            this.next = next;
            this.previous = prev;
        }

    }
}
