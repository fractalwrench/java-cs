package com.fractalwrench.structures;

/**
 * A Java implementation of a Stack data structure.
 * <p>
 * Stacks are LIFO
 *
 * @param <T> the type of data
 */
public class Stack<T> {

    private static final String EMPTY_STACK_MSG = " cannot be called on an Empty Stack!";

    private Node<T> top;
    private int size;

    /**
     * Removes the top-most object from the stack and returns it
     * <p>
     * O(1)
     *
     * @return the popped object
     * @throws IllegalStateException - if no items are in the stack
     */
    public T pop() throws IllegalStateException {
        if (top == null) {
            throw new IllegalStateException("pop() " + EMPTY_STACK_MSG);
        } else {
            T data = top.data;
            top = top.next;
            size--;
            return data;
        }
    }

    /**
     * Adds the given object to the top of the stack
     * <p>
     * O(1)
     *
     * @param object the given object
     */
    public void push(T object) {
        Node<T> node = new Node<>(object);
        node.next = top;
        top = node;
        size++;
    }

    /**
     * Retrieves the top-most object from the stack and returns it
     * <p>
     * O(1)
     *
     * @return the top-most object
     */
    public T peek() {
        if (top == null) {
            throw new IllegalStateException("pop() " + EMPTY_STACK_MSG);
        } else {
            return top.data;
        }
    }

    /**
     * Determines whether there are any objects in the stack
     * <p>
     * O(1)
     *
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Determines the number of objects in the stack
     * <p>
     * O(1)
     *
     * @return the stack's size
     */
    public int size() {
        return size;
    }

    /**
     * Holds the data and a pointer to the {@link Node} below.
     *
     * @param <T> the data type
     */
    private static class Node<T> {

        private final T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

}
