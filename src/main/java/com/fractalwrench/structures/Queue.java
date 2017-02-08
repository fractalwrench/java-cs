package com.fractalwrench.structures;

/**
 * A Java implementation of a Queue data structure.
 *
 * Queues are FIFO.
 * @param <T> the data type
 */
public class Queue<T> {

    private Node<T> first, last;
    private int size;

    /**
     * Removes and returns the first object in the queue
     * @return the first object in the queue
     */
    public T dequeue() {
        if (first != null) {
            size--;
            T data = first.data;
            first = first.next;

            if (first == null) {
                last = null; // avoid memory leak by removing reference
            }

            return data;
        }
        return null;
    }

    /**
     * Adds the given object to the last position in the queue
     * @param object the given object
     */
    public void enqueue(T object) {
        Node<T> node = new Node<>(object);

        if (first == null) {
            last = node;
            first = last;
        }
        else {
            last.next = node;
            last = node;
        }

        size++;
    }

    /**
     * Determines the number of elements currently enqueued
     * @return the number of elements
     */
    public int size() {
        return size;
    }

    /**
     * Determines whether the queue has any elements or not
     * @return true if no elements, otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {

        private final T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

}
