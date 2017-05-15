package com.greensnow25;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.DoubleSupplier;

/**
 * public class SimpleArrayOne.
 *
 * @author greensnow25.
 * @version 1.
 * @since 14.05.2017.
 */
public class SimpleArray<T> {
    /**
     * list.
     */
    private List<T> list;

    /**
     * constructor.
     */
    public SimpleArray() {
        this.list = new ArrayList<T>(10);
    }

    /**
     * add value to the list.
     *
     * @param value some value.
     */
    public void add(T value) {
        list.add(value);
    }

    /**
     * remove element of collection.
     *
     * @param element element.
     */
    public void delete(T element) {
        list.remove(this.search(element));
    }

    /**
     * update element.
     *
     * @param element    old element.
     * @param newElement new element.
     */
    public void update(T element, T newElement) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            T item = it.next();
            if (item.equals(element)) {
                list.set(list.indexOf(item), newElement);
            }
        }
    }

    /**
     * search element of collection.
     *
     * @param element witch you need to find.
     * @return found element.
     */
    public T search(T element) {
        for (T value : this.list) {
            if (value.equals(element)) {
                return value;
            }
        }
        return null;
    }

    /**
     * get index.
     *
     * @param index index.
     * @return Base object.
     */
    public T get(int index) {
        return list.get(index);
    }

    /**
     * get list.
     *
     * @return list.
     */
    public List<T> getList() {
        return list;
    }
}
