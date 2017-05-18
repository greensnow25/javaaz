package greensnow25.com.cyclicity;

/**
 * public class Node.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.05.2017.
 */
public class Node<T> {
    /**
     * Value.
     */
    private T value;
    /**
     * Link to next node.
     */
    private Node<T> next;

    /**
     * constructor.
     *
     * @param value T value.
     * @param next  link to next Node.
     */
    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
