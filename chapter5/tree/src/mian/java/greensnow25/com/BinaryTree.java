package greensnow25.com;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * public class BinaryTree.
 *
 * @author greensnow25.
 * @version 1.
 * @since 30.05.2017.
 */
public class BinaryTree<E extends Comparable> {
    /**
     * root of tree.
     */
    private Node<E> root = null;

    /**
     * add value to the tree.
     *
     * @param element added element.
     * @return true if successful.
     */
    public boolean add(E element) {
        Node<E> tmp = this.root;
        Node<E> previousNode = null;

        if (root == null) this.root = new Node<>(element);
        else {
            while (tmp != null) {
                previousNode = tmp;
                tmp = element.compareTo(tmp.value) > 0 ? tmp.right : tmp.left;
            }
            if (element.compareTo(previousNode.value) > 0) {
                previousNode.right = new Node<>(element);
            } else {
                previousNode.left = new Node<>(element);
            }
        }
        return true;
    }

    /**
     * getDepth of element;
     *
     * @param element
     * @return
     */
    public int getDepth(E element) {
        Node<E> tmp = this.root;
        int count = 0;
        while (tmp != null) {
            if (element.compareTo(tmp.value) == 0) break;
            tmp = element.compareTo(tmp.value) > 0 ? tmp.right : tmp.left;
            count++;
        }
        if (tmp == null || tmp.value.compareTo(element) != 0)
            throw new NoSuchElementException("There is no such element");
        return count;
    }

    /**
     * inner claas Node.
     *
     * @param <E> jeneric.
     */
    private class Node<E> {
        /**
         * left node.
         */
        private Node<E> left;
        /**
         * right node.
         */
        private Node<E> right;
        /**
         * value.
         */
        private E value;

        /**
         * constructor.
         *
         * @param value node value.
         */
        public Node(E value) {
            this.value = value;
        }

    }

    /**
     * get root Node.
     *
     * @return root.
     */
    public Node<E> getRoot() {
        return root;
    }
}
