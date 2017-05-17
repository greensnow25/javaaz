package greensnow25.com.linkedList;

import greensnow25.com.arrayList.ArrayListContainer;

import java.util.Iterator;

/**
 * public class LinkedList.
 *
 * @author greensnow25.
 * @version 1.
 * @since 16.05.2017.
 */
public class SimpleLinkedList<T> implements ArrayListContainer<T> {

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
    public SimpleLinkedList() {
        this.lastItem = new Node<T>(this.firstItem, null, null);
        this.firstItem = new Node<T>(null, null, this.lastItem);
    }

    /**
     * add node to the list.
     *
     * @param t node.
     */
    @Override
    public void add(T t) {
        Node<T> prev = lastItem;
        prev.setCurrent(t);
        lastItem = new Node<T>(prev, null, null);
        prev.setNext(this.lastItem);
        size++;
    }

    /**
     * get node by index.
     *
     * @param index in the container.
     * @return node.
     */
    @Override
    public T get(int index) {
        Node<T> node = firstItem.getNext();
        for (int i = 0; i != index; i++) {
            node = this.returnCurrentItem(node);
        }
        return node.getCurrent();
    }

    /**
     * Method returns a reference to the next element.
     *
     * @param node curent node.
     * @return node.
     */
    private Node<T> returnCurrentItem(Node<T> node) {
        return node.getNext();

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
            private Node<T> node;

            /**
             * check, does next element exist.
             *
             * @return if exist , return true.
             */
            @Override
            public boolean hasNext() {
                return index < size;
            }

            /**
             * return next node from a given sequence,.
             * if no more nodes return NPE.
             *
             * @return node.
             */
            @Override
            public T next() {
                Node<T> tmp = null;
                if (index == 0) {
                    tmp = this.node;
                    tmp = firstItem.getNext();
                    this.node = tmp;
                    index++;
                    return tmp.getCurrent();
                }
                for (int i = index++; i < size; i++) {
                    node = returnCurrentItem(node);
                    tmp = this.node;
                    break;
                }
                return tmp.getCurrent();
            }
        };
    }
}
