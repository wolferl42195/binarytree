package binarytree;

import java.io.IOException;
import java.io.StringWriter;

/**
 * The Class BinaryTree.
 *
 * @param <T> the generic type
 */
public class BinaryTree<T extends Comparable<T>> implements BinaryTreeInterface<T> {

    private Node<T> rootNode = null;

    private Node<T> currentNode = null;

    public void clear() {
        rootNode = null;
        currentNode = null;
    }

    public int countElements() {
        if (rootNode != null) {
            return rootNode.countElements();
        }
        return 0;
    }

    public Comparable<T> getFirstElement() {
        if (rootNode == null) {
            return null;
        }
        currentNode = rootNode.getFirstElement();
        return currentNode.getDataObject();
    }

    public Comparable<T> getLastElement() {
        if (rootNode == null) {
            return null;
        }
        currentNode = rootNode.getLastElement();
        return currentNode.getDataObject();
    }


    public Comparable<T> getNextElement() {
        currentNode = currentNode.getNextElement();
        return currentNode.getDataObject();
    }

    public Comparable<T> getPreviousElement() {
        currentNode = currentNode.getPreviousElement();
        return currentNode.getDataObject();
    }

    public boolean insertElement(Comparable<T> c) {
        boolean ok = false;
        if (c != null) {
            //Case insert 1: no root node -> create root node
            if (rootNode == null) {
                rootNode = new Node<>(null, c);
                currentNode = rootNode;
            } else {
                //Case insert: root is here, node handles the rest
                currentNode = rootNode.insertElement(c);
            }
            ok = (currentNode != null);
        }
        return ok;
    }

    /* (non-Javadoc)
     * @see BinaryTreeInterface#remove()
     */
    public boolean remove() {
        boolean ok = false;
        if (currentNode != null) {
            if (currentNode == rootNode) {
                currentNode = currentNode.removeElement();
                rootNode = currentNode;
            } else {
                currentNode = currentNode.removeElement();
            }
            ok = true;
        }
        return ok;
    }

    public Comparable<T> getCurrentElement() {
        return currentNode.getDataObject();
    }

    /**
     * Gets the root node.
     *
     * @return the root node
     */
    public Node<T> getRootNode() {
        return rootNode;
    }

    /**
     * Sets the root node
     *
     * @param root the new root node
     */
    public void setRootNode(Node<T> root) {
        this.rootNode = root;
    }


    /**
     * Gets the total tree depth.
     *
     * @return the total tree depth
     */
    public int getTotalTreeDepth() {
        return rootNode.getDepth();
    }


    /**
     * Gets the depth of the current node
     *
     * @return the depth of the current node
     */
    public int getDepth() {
        return currentNode.getDepth();
    }


    /**
     * Prints the tree
     */
    public String print() {
        StringWriter out = new StringWriter();
        String s = "No tree to print";
        if (rootNode != null) {
            try {
                rootNode.printTree(out);
                s = out.toString();
            } catch (IOException e) {
                System.out.println("Problem printing");
            }
        }
        return s;
    }

    /**
     * Finds the element
     *
     * @param c the object implementing the comparable interface
     * @return true, if successful found the element in the tree
     */
    public boolean findElement(Comparable<T> c) {
        if (rootNode != null && c != null) {
            currentNode = rootNode.getFirstElement();
            if (currentNode.checkNodeOwnsComparable(c)) {
                return true;
            }
            Node<T> lastNode = rootNode.getLastElement();
            while (currentNode != lastNode) {
                currentNode = currentNode.getNextElement();
                if (currentNode.checkNodeOwnsComparable(c)) {
                    break;
                }
            }
            return currentNode.checkNodeOwnsComparable(c);
        }
        return false;
    }
}
