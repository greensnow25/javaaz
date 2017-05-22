package greensnow25.com.queue;

import greensnow25.com.linkedList.SimpleLinkedList;

import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * public class SimpleQueue.
 *
 * @author greensnow25.
 * @version 1.
 * @since 17.05.2017.
 */
public class SimpleQueue<T> implements greensnow25.com.queue.Queue<T> {
    /**
     * class object.
     */
    private SimpleLinkedList<T> linkedList;

    /**
     * constructor.
     *
     * @param linkedList linkedList.
     */
    public SimpleQueue(SimpleLinkedList<T> linkedList) {
        this.linkedList = linkedList;
    }

    /**
     * Returns, but does not remove an element from the beginning of the queue.
     *
     * @return element.
     * @throws NoSuchElementException if queue is empty.
     */
    @Override
    public T element() throws NoSuchElementException {
        T element = null;
        try {
            element = this.linkedList.get(0);

        } catch (NullPointerException ex) {
            throw new NoSuchElementException("empty");
        }
        return element;
    }

    /**
     * Adds the obj element to the end of the queue.
     *
     * @param object object.
     * @return If the element is successfully added, returns true, otherwise - false.
     */
    @Override
    public boolean offer(T object) {
        int last = this.linkedList.getSize();
        this.linkedList.add(object);
        int now = this.linkedList.getSize();

        return now - 1 == last;
    }

    /**
     * Returns without removing the element from the beginning of the queue. If the queue is empty, returns null.
     *
     * @return object.
     */
    @Override
    public T peek() {
        if (linkedList.getFirstItem() == null) {
            return null;
        }
        return this.linkedList.get(0);
    }

    /**
     * Returns an element from the beginning of the queue with deletion. If the queue is empty, returns null.
     *
     * @return object.
     */
    @Override
    public T poll() {
        T object = null;
        if (this.linkedList.getSize() != 0) {
            object = this.linkedList.removeFirst();
        }
        return object;
    }

    /**
     * Returns an element from the beginning of the queue with deletion.
     *
     * @return removing element.
     * @throws NoSuchElementException if queue is empty.
     */
    @Override
    public T remove() throws NoSuchElementException {
        if (linkedList.getFirstItem() == null) throw new NoSuchElementException("empty");
        T object = this.linkedList.get(0);
        return object;
    }
}
