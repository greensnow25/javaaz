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
public class SimpleArray<E> {
    /**
     * list.
     */
    private List<E> list;

    /**
     * constructor.
     */
    public SimpleArray() {
        this.list = new ArrayList();
    }

    /**
     * add value to the list.
     *
     * @param value some value.
     */
    public void add(E value) {
        list.add((E)value);
    }

    /**
     * remove element of collection.
     *
     * @param element element.
     */
    public void delete(E element) {
        list.remove(this.search(element));
    }

    /**
     * update element.
     *
     * @param element    old element.
     * @param newElement new element.
     */
    public void update(E element, E newElement) {
        Iterator<E> it = list.iterator();
        while (it.hasNext()) {
            E item = it.next();
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
    public E search(E element) {
        for (E value : this.list) {
            if (value.equals(element)) {
                return(E) value;
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
    public E get(int index) {
        return (E)list.get(index);
    }

    /**
     * get list.
     *
     * @return list.
     */
    public List getList() {
        return list;
    }
}
