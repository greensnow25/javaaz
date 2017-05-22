package greensnow25.com.stack;

import greensnow25.com.linkedList.SimpleLinkedList;

/**
 * public class SimpleStack.
 *
 * @author greensnow25.
 * @version 1.
 * @since 17.05.2017.
 */
public class SimpleStack<T> {

    SimpleLinkedList linkedList;

    public SimpleStack(SimpleLinkedList linkedList) {
        this.linkedList = linkedList;
    }

    /**
     * Returns the top element without removing it from the stack.
     *
     * @return top element.
     */
    public T peek() {
        return (T) this.linkedList.get(linkedList.getSize() - 1);
    }

    /**
     * Removes the top element by removing it from the stack.
     *
     * @return top element.
     */
    public T pop() {
        return (T) linkedList.removeLast();
    }

    /**
     * push object to the top of the stack.
     *
     * @param object object.
     * @return object.
     */
    public T push(T object) {
        this.linkedList.add(object);
        return (T) this;
    }

    /**
     * The method looks for the given item on the stack, returning the number of pop operations
     * that are required to translate the item to the top of the stack. If there is no given
     * item in the stack, this method returns -1.
     *
     * @return number of pop operations .
     */
    public int search(T object) {
        int moves = 0;
        for (int i = linkedList.getSize()-1; i >=0; i--) {
            T value = (T) linkedList.get(i);
            if (value != null && value.equals(object)) {
                return moves;
            }
            moves++;
        }
        return -1;

    }

    private Node<T> returnCurrent(Node<T> object) {
        return object.getPrevious();
    }

}
