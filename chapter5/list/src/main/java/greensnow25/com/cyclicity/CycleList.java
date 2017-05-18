package greensnow25.com.cyclicity;

/**
 * public class Cyclisity.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.05.2017.
 */
public class CycleList<T> implements Cycle<T> {
    /**
     * first node.
     */
    private Node<T> firstNode;
    /**
     * last node.
     */
    private Node<T> lastNode;
    /**
     * list sile.
     */
    private int size = 0;

    /**
     * constructor.
     */
    public CycleList() {
        this.lastNode = new Node<T>(null, null);
        this.firstNode = new Node<T>(null, this.lastNode);
    }

    /**
     * Adds a value to a list that does not have a cycle.
     *
     * @param value value to add.
     */
    public void addToNoCycle(T value) {
        lastNode.setValue(value);
        Node<T> tmp = lastNode;
        lastNode = new Node<T>(null, null);
        tmp.setNext(lastNode);
        size++;
    }

    /**
     * Adds a value to a list that have a cycle.
     *
     * @param value value to add.
     */
    public void addToListWithCycle(T value) {
        lastNode.setValue(value);
        Node<T> tmp = lastNode;
        lastNode = new Node<T>(null, this.firstNode);
        tmp.setNext(lastNode);
        size++;
    }

    /**
     * check has list a cycle.
     *
     * @param first first Node.
     * @return true, if have cycle.
     */
    @Override
    public boolean hasCycle(Node<T> first) {
        try {
            Node<T> node = firstNode.getNext();
            for (int i = 0; i != size + 2; i++) {
                node = returnCurrentNode(node);
                if (first.equals(node)) {
                    return true;
                }
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * The method moves the pointer over the list.
     *
     * @param node current position.
     * @return next node.
     */
    private Node<T> returnCurrentNode(Node<T> node) {
        return node.getNext();
    }

    /**
     * get first node.
     *
     * @return first node.
     */
    public Node<T> getFirstNode() {
        return firstNode;
    }
}
