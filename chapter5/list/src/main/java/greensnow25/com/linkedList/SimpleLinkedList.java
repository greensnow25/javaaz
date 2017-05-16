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
    private Item<T> firstItem;
    /**
     * the last element of a given sequence.
     */
    private Item<T> lastItem;


    int size = 0;

    public SimpleLinkedList() {

        this.lastItem = new Item<T>(this.firstItem, null, null);
        this.firstItem = new Item<T>(null, null, this.lastItem);
    }

    @Override
    public void add(T t) {
        Item<T> prev = lastItem;
        prev.setCurrent(t);
        lastItem = new Item<T>(prev, null, null);
        prev.setNext(this.lastItem);
      //  lastItem.setNext(firstItem);
        size++;
    }

    @Override
    public T get(int index) {
        Item<T> item = firstItem.getNext();
        for (int i = 0; i != index; i++) {
            item = this.returnCurrentItem(item);
        }
        return item.getCurrent();
    }

    private Item<T> returnCurrentItem(Item<T> item) {
        return item.getNext();

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            private Item<T> item;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (index == 0) {
                    item = firstItem.getNext();
                    index++;
                    return item.getCurrent();
                }
                for (int i = index++; i != size; i++) {
                    item = returnCurrentItem(item);
                    break;
                }
                return item.getCurrent();
            }
        };
    }
}
