package com.fractalwrench.structures;

/**
 * Defines methods for a LinkedList structure, which consists of nodes that point to each other
 *
 * @param <T> the type of data
 */
public interface LinkedList<T> {

    /**
     * Inserts an object at the first position
     *
     * @param object the object
     */
    void insertFirst(T object);

    /**
     * Inserts an object at the last position
     *
     * @param object the object
     */
    void insertLast(T object);

    /**
     * Deletes the object at the first position
     *
     * @return the object, or null if none present
     * @throws IllegalArgumentException if index > size
     */
    T deleteFirst() throws IllegalArgumentException;

    /**
     * Deletes the object at the last position
     *
     * @return the object, or null if none present
     * @throws IllegalArgumentException if index > size
     */
    T deleteLast() throws IllegalArgumentException;

    /**
     * Determines the size of the linked list
     *
     * @return the size
     */
    int size();

    /**
     * Determines whether the linked list is empty or not
     *
     * @return true if empty, otherwise false
     */
    boolean isEmpty();

    /**
     * Retrieves the first index where the given object is found, or -1 if it is not present
     *
     * @param object the object
     * @return the index
     */
    int indexOf(T object);

    /**
     * Inserts the object to the given index
     *
     * @param index  the index
     * @param object the object
     * @throws IllegalArgumentException if index > size
     */
    void insertAtIndex(int index, T object) throws IllegalArgumentException;

    /**
     * Removes the object from the given index
     *
     * @param index the index
     * @return the object
     * @throws IllegalArgumentException if no object exists at that index
     */
    T deleteFromIndex(int index) throws IllegalArgumentException;

}
