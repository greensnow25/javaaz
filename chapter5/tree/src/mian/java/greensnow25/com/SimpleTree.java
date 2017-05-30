package greensnow25.com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * public class SimpleTree.
 *
 * @author greensnow25.
 * @version 1.
 * @since 29.05.2017.
 */
public class SimpleTree<E extends Comparable> implements ISimpleTree<E> {

    /**
     * root.
     */
    private Node<E> root = null;


    /**
     * add element child to parent.
     * Parent can have a child list.
     *
     * @param parent parent.
     * @param child  child.
     * @return
     */
    @Override
    public boolean add(E parent, E child) {
        if (root == null) {
            root = new Node<>(child);
        } else {
            Node nodeParent = this.search(this.root, parent);
            if (nodeParent == null) {
                return false;
            } else {
                nodeParent.children.add(new Node<E>(child));
            }
        }
        return true;
    }

    /**
     * The method checks if the tree is binary.
     *
     * @return true, if binary, else false.
     */
    @Override
    public boolean isBinary() {

        return this.recSearchBinary(this.root);
    }

    /**
     * Recursive passage through the elements of a tree
     * @param eNode node.
     * @return result.
     */
    private boolean recSearchBinary(Node<E> eNode) {
        boolean res = true;
        if (eNode.children.size() > 2) return false;
        for (Node node : eNode.children) {
            res = this.recSearchBinary(node);
        }
        return res;
    }

    /**
     * method return object iterator, for the passage through the tree.
     *
     * @return Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * position in the tree.
             */
            private E position = null;
            /**
             * minimal value of the tree.
             */
            private E minValueTree = root.value;
            /**
             * maximal value of the tree.
             */
            private E maxValueTree = root.value;
            /**
             * Single use indicator.
             */
            boolean findMinMax = true;


            /**
             *The method checks for the presence of the following element.
             * @return true if exist, else false.
             */
            @Override
            public boolean hasNext() {
                return this.position.compareTo(this.maxValueTree) < 0;
            }

            /**
             * method return next value after the pointer.
             * @throws NoSuchElementException If the pointer is on the last element and an attempt.
             *                               is made to call this method
             * @return value.
             */
            @Override
            public E next() {
                if (findMinMax) {
                    this.findMinValue(root);
                    this.position = this.minValueTree;
                    this.findMaxValue(root);
                    this.findMinMax = false;
                    this.position = minValueTree;
                    return position;
                }
                if (this.position == this.maxValueTree) throw new NoSuchElementException("no elements");
                this.position = this.nextValue(root, maxValueTree);

                return this.position;
            }

            /**
             * find minimal value in the tree.
             * @param node node.
             */
            private void findMinValue(Node<E> node) {
                for (Node nod : node.children) {
                    if (this.minValueTree.compareTo(nod.value) > 0) {
                        minValueTree = (E) nod.value;
                    }
                    this.findMinValue(nod);
                }
            }

            /**
             * find maximum value in the tree.
             * @param node node.
             */
            private void findMaxValue(Node<E> node) {
                for (Node nod : node.children) {
                    if (this.maxValueTree.compareTo(nod.value) < 0) {
                        maxValueTree = (E) nod.value;
                    }
                    this.findMaxValue(nod);
                }
            }

            /**
             *The method recursively passes through the tree, and comparing all the elements.
             *  with each other and returns, the element next by value moves the cursor one position.
             * @param node The current element is passed to the method.
             * @param current The closest element to the pointer.
             * @return next value after the pointer.
             */
            private E nextValue(Node<E> node, E current) {
                E res = current;
                if (this.position.compareTo(node.value) < 0 && current.compareTo(node.value) >= 0) {
                    res = node.value;
                }
                for (Node nod : node.children) {
                    if (this.position.compareTo(nod.value) < 0 && res.compareTo(nod.value) > 0) {
                        res = (E) nod.value;
                    }
                    res = (E) this.nextValue(nod, res);
                }
                return res;
            }
        };
    }

    /**
     * The method looks for the specified element.
     *
     * @param node   current node.
     * @param parent the object to be found.
     * @return founded object.
     */
    private Node<E> search(Node<E> node, E parent) {
        Node res = null;
        if (node.value.compareTo(parent) == 0) {
            res = node;
            return res;
        }
        for (Node<E> nod : node.children) {
            if (nod.value.compareTo(parent) == 0) {
                res = nod;
                return res;
            } else if (this.search(nod, parent) != null) {
                res = this.search(nod, parent);
            }
        }
        return res;
    }

    /**
     * inner class Node.
     *
     * @param <E> param.
     * @author greensnow25.
     */
    private class Node<E> {
        /**
         * children list.
         */
        private List<Node<E>> children;
        /**
         * value
         */
        private E value;

        /**
         * constructor.
         *
         * @param value value of the node.
         */
        public Node(E value) {
            this.children = new ArrayList<>();
            this.value = value;
        }
    }
}
