package greensnow25.com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    private Node<E> root;

    public SimpleTree(E parent) {
        this.root = new Node<>(parent);
    }

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
        Node nodeParent = this.search(this.root, parent);
        if (nodeParent == null) {
            return false;
        } else {
            nodeParent.children.add(new Node<E>(child));
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> node = root;
            private Node tmp = null;
            private E minValueTree = root.value;
            Node<E> position;

            @Override
            public boolean hasNext() {
                return this.search(this.node).value != null;
            }

            @Override
            public E next() {
//                this.node = search(this.node);
//                return node.value;

                return null;
            }

            private E minValue(Node<E> min) {
                if (this.minValueTree.compareTo(min.value) > 0) {
                    minValueTree = (E) min.value;
                    System.out.println(minValueTree);
                }
                return minValueTree;
            }

            private void findMinValue(Node<E> node) {
                for (Node nod : node.children) {
                    minValueTree = (E) minValue(nod);
                    this.findMinValue(nod);
                    System.out.println(minValueTree);
                }
            }

            private void nextValue(Node<E> node) {
                E tmp = null;
                if (minValueTree.compareTo(node.value) < -1 && position == null) {
                    position = node;
                }else if(minValueTree.compareTo(node)<-1 && position.value.compareTo()){

                }

            }

            private Node search(Node<E> node) {
                for (Node nod : node.children) {
                    if (nod.value != null) {

                        this.search(nod);
                        System.out.println(minValueTree);
                    } else {
                        this.search(nod);
                    }
                }
                return null;
            }
        };
    }

    private Node<E> search(Node<E> node, E parent) {
        Node res = null;
        if (node.children == null) {
            return null;
        } else if (node.value.equals(parent)) return node;
        for (Node nod : node.children) {
            if (nod.value == parent) {
                return nod;
            } else {
                node = this.search(nod, parent);
            }
        }
        return res;
    }

    private class Node<E> {
        /**
         * children list.
         */
        private List<Node<E>> children;
        /**
         * value
         */
        private E value;

        public Node(E value) {
            this.children = new ArrayList<>();
            this.value = value;
        }
    }
}
