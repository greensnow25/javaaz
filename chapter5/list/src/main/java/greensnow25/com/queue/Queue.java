package greensnow25.com.queue;

import java.util.NoSuchElementException;

/**
 * public class Queue.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.05.2017.
 */
public interface Queue<T> {
    /**
     * Returns, but does not remove an element from the beginning of the queue.
     * @return element.
     * @throws NoSuchElementException if queue is empty.
     */
    T element() throws NoSuchElementException;

    /**
     * Adds the obj element to the end of the queue.
     * @param object object.
     * @return If the element is successfully added, returns true, otherwise - false.
     */
    boolean offer(T object);

    /**
     * Returns without removing the element from the beginning of the queue. If the queue is empty, returns null.
     * @return object.
     */
    T peek();

    /**
     * Returns an element from the beginning of the queue with deletion. If the queue is empty, returns null.
     * @return object.
     */
    T poll();

    /**
     * Returns an element from the beginning of the queue with deletion.
     * @return removing element.
     * @throws NoSuchElementException if queue is empty.
     */
    T remove() throws NoSuchElementException;
}
