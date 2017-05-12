package com.greensnow25.iteratorIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * public class ConertIterator.
 *
 * @author greensnow25.
 * @version 1.
 * @since 10.05.2017.
 */
public class ConvertIterator implements Iterator<Integer> {
    /**
     * iterator.
     */
    private final Iterator<Iterator<Integer>> iterator;

    /**
     * current iterator.
     */
    private Iterator<Integer> current;

    /**
     * constructor.
     *
     * @param iterator
     */
    public ConvertIterator(Iterator<Iterator<Integer>> iterator) {
        this.iterator = iterator;
    }

    /**
     * method return current iterator.
     *
     * @param iterator iterator.
     * @return
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> iterator) {
        if (current != null && current.hasNext()) {
            return this;
        }
        while (iterator.hasNext()) {
            current = iterator.next();
            break;
        }
        return this;
    }

    /**
     * method check next vavue.
     *
     * @return true, if iterator has next value.
     */
    @Override
    public boolean hasNext() {
        if (current != null && current.hasNext()) {
            return true;
        }
        return false;
    }

    /**
     * the method returns the current value and moves the carriage one value to the right.
     *
     * @return current value and move carriage.
     */
    @Override
    public Integer next() {
        Integer number = 0;
        this.convert(this.iterator);
        if (current != null && current.hasNext()) {
            number = current.next();

        } else {
            throw new ArrayIndexOutOfBoundsException("Out");
        }
        return number;
    }
}
