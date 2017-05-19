package greensnow25.com.link;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * public class SimpleLinkedSet.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.05.2017.
 */
public class SimpleLinkedSet<T> implements Iterable<T> {

    /**
     * first Node.
     */
    private final Node<T> firstNode;

    /**
     * last node.
     */
    private Node<T> lastNode;
    /**
     * int size.
     */
    private int size = 0;

    /**
     * constructor.
     */
    public SimpleLinkedSet() {

        this.lastNode = new Node<T>(null, null, null);
        this.firstNode = new Node<T>(null, null, this.lastNode);
        this.lastNode.setPrevious(this.firstNode);
    }

    /**
     * Checking the value for originality.
     *
     * @param value value.
     * @return true if origin.
     */
    private boolean checkOriginal(T value) {
        boolean original = true;
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            T t = (T) iterator.next();
            if (t.equals(value)) {
                original = false;
                break;
            }
        }
        return original;
    }

    /**
     * add value to set.
     *
     * @param value input vavue.
     */
    public void add(T value) {
        if (checkOriginal(value)) {
            Node<T> prev = lastNode;
            prev.setCurrent(value);
            this.lastNode = new Node<T>(prev, null, null);
            prev.setNext(this.lastNode);
            this.size++;
        }
    }

    /**
     * create new Iterator object/
     *
     * @return new object.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;
            private Node node = firstNode;

            /**
             * check next element.
             * @return if element is exist - true.
             */
            @Override
            public boolean hasNext() {
                return size > this.position;
            }

            /**
             * The method moves the pointer over the set.
             * @return element of set.
             */
            @Override
            public T next() {
                node = returnNextNode(node);
                position++;
                if (node == null) {
                    throw new NoSuchElementException(" no more elements.");
                }
                return (T) node.getCurrent();

            }
        };
    }

    /**
     * get next node.
     *
     * @param node node of set.
     * @return next node.
     */
    private Node returnNextNode(Node node) {
        return node.getNext();
    }

    /**
     * get size.
     *
     * @return size.
     */
    public int getSize() {
        return size;
    }
}
