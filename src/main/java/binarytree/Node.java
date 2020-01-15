package binarytree;

import java.io.IOException;
import java.io.StringWriter;


/**
 * The Class Node.
 *
 * @param <T> the generic type
 */
public class Node<T> {

    private Node<T> parentNode;

    private Node<T> leftNode = null;

    private Node<T> rightNode = null;

    private Comparable<T> dataObject;

    /**
     * Instantiates a new node.
     *
     * @param parentNode the parentNode
     * @param c          the comparable object
     */
    public Node(Node<T> parentNode, Comparable<T> c) {
        this.parentNode = parentNode;
        this.dataObject = c;
    }


    /**
     * Gets the data object.
     *
     * @return the data object
     */
    public Comparable<T> getDataObject() {
        return dataObject;
    }


    /**
     * Gets the left node.
     *
     * @return the left node
     */
    public Node<T> getLeftNode() {
        return leftNode;
    }


    /**
     * Sets the left node
     *
     * @param leftNode the new left node
     */
    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }


    /**
     * Gets the parent node.
     *
     * @return the parent node
     */
    public Node<T> getParentNode() {
        return parentNode;
    }


    /**
     * Sets the parent node.
     *
     * @param parentNode the new parent node
     */
    public void setParentNode(Node<T> parentNode) {
        this.parentNode = parentNode;
    }


    /**
     * Gets the right node.
     *
     * @return the right node
     */
    public Node<T> getRightNode() {
        return rightNode;
    }


    /**
     * Sets the right node.
     *
     * @param rightNode the new right node
     */
    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    /**
     * Gets the next element.
     *
     * @return the next element
     */
    public Node<T> getNextElement() {
        if (rightNode != null)
            return rightNode.getFirstElement();

        Node<T> search = this;
        while (search.parentNode != null && search.parentNode.leftNode != search)
            search = search.parentNode;

        if (search.parentNode == null) {
            return this;
        }

        return search.parentNode;
    }

    /**
     * Gets the previous element.
     *
     * @return the previous element
     */
    public Node<T> getPreviousElement() {
        if (leftNode != null)
            return leftNode.getLastElement();

        Node<T> node = this;
        while (node.getParentNode() != null && node.getParentNode().getRightNode() != node)
            node = node.getParentNode();

        if (node.getParentNode() == null) {
            return this;
        }

        return node.parentNode;
    }

    /**
     * Insert element which implements the comparable interface
     *
     * @param c the element implements the comparable interface
     */
    @SuppressWarnings("unchecked")
    public Node<T> insertElement(Comparable<T> c) {
        Node<T> node = null;
        //Case insert 2: new object is smaller and left already exists
        if (c.compareTo((T) dataObject) <= 0 && leftNode != null) {
            node = this.leftNode.insertElement(c);
        }
        //Case insert 3: new object is bigger and right already exists
        if (c.compareTo((T) dataObject) > 0 && rightNode != null) {
            node = this.rightNode.insertElement(c);
        }
        //Case insert 4: new object is smaller and left does not exist
        if (c.compareTo((T) dataObject) <= 0 && leftNode == null) {
            node = new Node<>(this, c);
            leftNode = node;
        }

        //Case insert 5: new object is bigger and right does not exist
        if (c.compareTo((T) dataObject) > 0 && rightNode == null) {
            node = new Node<T>(this, c);
            rightNode = node;
        }
        return node;
    }

    /**
     * Gets the first element.
     *
     * @return the first element
     */
    public Node<T> getFirstElement() {
        if (leftNode == null)
            return this;
        else {
            return (leftNode.getFirstElement());
        }
    }


    /**
     * Gets the last element.
     *
     * @return the last element
     */
    public Node<T> getLastElement() {
        if (rightNode == null)
            return this;
        else {
            return (this.rightNode.getLastElement());
        }
    }

    /**
     * Count elements.
     *
     * @return the number of elements in the tree
     */
    public int countElements() {
        int countLeft = 0;
        int countRight = 0;
        if (this.getLeftNode() != null) {
            countLeft = leftNode.countElements();
        }
        if (this.getRightNode() != null) {
            countRight = rightNode.countElements();
        }
        return 1 + countLeft + countRight;
    }


    /**
     * Removes the element.
     *
     * @return the node
     */
    public Node<T> removeElement() {
        //case remove 1: remove root which is the last node, good bye tree
        if (parentNode == null && rightNode == null && leftNode == null) {
            return null;
        }

        //case remove 2: remove root which has only nodes on the right
        if (parentNode == null && leftNode == null) {
            rightNode.setParentNode(null);
            return rightNode;
        }

        //case remove 3: remove root which has only nodes on the left
        if (parentNode == null && rightNode == null) {
            leftNode.setParentNode(null);
            return leftNode;
        }

        //case remove 4: remove root with elements left and right
        if (parentNode == null) {
            Node<T> n = leftNode.getLastElement();
            n.setRightNode(rightNode);
            rightNode.setParentNode(n);
            leftNode.setParentNode(null);
            return leftNode;
        }

        //case remove 5: remove node with where left and right are do not exist
        if (leftNode == null && rightNode == null) {
            if (parentNode.getRightNode() == this) {
                parentNode.setRightNode(null);
            }
            if (parentNode.getLeftNode() == this) {
                parentNode.setLeftNode(null);
            }
        } else {
            //case remove 6: remove node and left node exists but no right one and the node is in left of parent
            if (leftNode != null && rightNode == null && parentNode.getLeftNode() == this) {
                parentNode.setLeftNode(leftNode);
                leftNode.setParentNode(parentNode);
            }
            //case remove 7: remove node and left node exists but no right one and the node is in right of parent
            if (leftNode != null && rightNode == null && parentNode.getRightNode() == this) {
                parentNode.setRightNode(leftNode);
                leftNode.setParentNode(parentNode);
            }

            //case remove 8: remove node and right node exists but no left one and the node is in right of parent
            if (rightNode != null && leftNode == null && parentNode.getRightNode() == this) {
                parentNode.setRightNode(rightNode);
                rightNode.setParentNode(parentNode);
            }

            //case remove 9: remove node and right node exists but no left one and the node is in left of parent
            if (rightNode != null && leftNode == null && parentNode.getLeftNode() == this) {
                parentNode.setLeftNode(rightNode);
                rightNode.setParentNode(parentNode);
            }

            //case remove 10: remove node and right and left node exists and the node is in left of parent
            if (leftNode != null && rightNode != null && parentNode.getLeftNode() == this) {
                Node<T> n = leftNode.getLastElement();
                n.setRightNode(rightNode);
                rightNode.setParentNode(n);
                parentNode.setLeftNode(leftNode);
                leftNode.setParentNode(parentNode);
            }

            //case remove 11: remove node and right and left node exists and the node is in right of parent
            if (leftNode != null && rightNode != null && parentNode.getRightNode() == this) {
                Node<T> n = rightNode.getFirstElement();
                n.setLeftNode(leftNode);
                leftNode.setParentNode(n);
                parentNode.setRightNode(rightNode);
                rightNode.setParentNode(parentNode);
            }
        }
        return parentNode;
    }

    /**
     * Gets the depth.
     *
     * @return the depth
     */
    public int getDepth() {
        int leftDepth = 0;
        int rightDepth = 0;
        if (leftNode != null) {
            leftDepth = leftNode.getDepth();
        }
        if (rightNode != null) {
            rightDepth = rightNode.getDepth();
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }

    /**
     * Checks if this node owns the comparable.
     *
     * @param c the comparable object of the type T
     * @return true, id the object is the same as in the node
     */
    @SuppressWarnings("unchecked")
    public boolean checkNodeOwnsComparable(Comparable<T> c) {
        return c.compareTo((T) dataObject) == 0;
    }


    /**
     * Prints the tree.
     *
     * @param out the StringWriter
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void printTree(StringWriter out) throws IOException {
        if (rightNode != null) {
            rightNode.printTree(out, true, "");
        }
        printNodeValue(out);
        if (leftNode != null) {
            leftNode.printTree(out, false, "");
        }
    }

    /**
     * Prints the node value.
     *
     * @param out the StringWriter for the output
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void printNodeValue(StringWriter out) throws IOException {
        if (dataObject == null) {
            out.write("<null>");
        } else {
            out.write(dataObject.toString());
        }
        out.write('\n');
    }

    /**
     * Prints the tree.
     *
     * @param out     the StringWriter for the output
     * @param isRight the is right
     * @param indent  the indent
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void printTree(StringWriter out, boolean isRight, String indent) throws IOException {
        if (rightNode != null) {
            rightNode.printTree(out, true, indent + (isRight ? "        " : " |      "));
        }
        out.write(indent);
        if (isRight) {
            out.write(" /");
        } else {
            out.write(" \\");
        }
        out.write("----- ");
        printNodeValue(out);
        if (leftNode != null) {
            leftNode.printTree(out, false, indent + (isRight ? " |      " : "        "));
        }
    }

    @Override
    public String toString() {
        return "Node [data=" + dataObject + "]";
    }
}
