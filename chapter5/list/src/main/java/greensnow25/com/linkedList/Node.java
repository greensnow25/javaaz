package greensnow25.com.linkedList;

import java.util.*;
import java.util.LinkedList;

/**
 * public class Node.
 *
 * @author greensnow25.
 * @version 1.
 * @since 16.05.2017.
 */
public class Node<T> {
    /**
     * current element.
     */
    private T current;
    /**
     * next element.
     */
    private Node<T> next;
    /**
     * previous element.
     */
    private Node<T> previous;

    /**
     * constructor.
     * @param prev previous element.
     * @param element current element.
     * @param next next element.
     */
    public Node(Node<T> prev, T element, Node<T> next) {
        this.current = element;
        this.next = next;
        this.previous = prev;
    }

    public T getCurrent() {
        return current;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setCurrent(T current) {
        this.current = current;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}
