package greensnow25.com.linkedList;

import java.util.*;
import java.util.LinkedList;

/**
 * public class Item.
 *
 * @author greensnow25.
 * @version 1.
 * @since 16.05.2017.
 */
public class Item<T> {
    /**
     * current element.
     */
    private T current;
    /**
     * next element.
     */
    private Item<T> next;
    /**
     * previous element.
     */
    private Item<T> previous;

    /**
     * constructor.
     * @param prev previous element.
     * @param element current element.
     * @param next next element.
     */
    public Item(Item<T> prev, T element, Item<T> next) {
        this.current = element;
        this.next = next;
        this.previous = prev;
    }

    public T getCurrent() {
        return current;
    }

    public Item<T> getNext() {
        return next;
    }

    public Item<T> getPrevious() {
        return previous;
    }

    public void setCurrent(T current) {
        this.current = current;
    }

    public void setNext(Item<T> next) {
        this.next = next;
    }

    public void setPrevious(Item<T> previous) {
        this.previous = previous;
    }
}
