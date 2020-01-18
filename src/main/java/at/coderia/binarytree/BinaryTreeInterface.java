package at.coderia.binarytree;

/**
 * The Interface for the BinaryTree to define the method needed.
 * This Interface supports the a generic type, so every class can be handled type save
 *
 * @param <T> the generic type
 */
public interface BinaryTreeInterface<T> {

    /**
     * Insert an element into the tree
     *
     * @param c the object which implements the comparable interface
     */
    boolean insertElement(Comparable<T> c);

    /**
     * Gets the first element from the tree. This is the most left element
     *
     * @return the first object
     */
    Comparable<T> getFirstElement();


    /**
     * Gets the last element from the tree. This is the most right element.
     *
     * @return the last object
     */
    Comparable<T> getLastElement();


    /**
     * Gets the next element from the current element. Used to navigate through the tree in the order defined by the compareTo method of T
     *
     * @return the next object
     */
    Comparable<T> getNextElement();

    /**
     * Gets the previous element from the current element. Used to navigate through the tree in the order defined by the compareTo method of T
     *
     * @return the prev
     */
    Comparable<T> getPreviousElement();

    /**
     * Gets the current element. Used to navigate through the tree
     *
     * @return the current
     */
    Comparable<T> getCurrentElement();

    /**
     * Removes the current node and the referenced object
     */
    boolean remove();

    /**
     * Clears the complete tree
     */
    void clear();

    /**
     * Counts the elements of the tree
     *
     * @return the number of objects currently in the tree
     */
    int countElements();

}
