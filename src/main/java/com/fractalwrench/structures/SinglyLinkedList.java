package com.fractalwrench.structures;


import java.util.Objects;

/**
 * A Java implementation of a Singly Linked List data structure,
 * with insertion/deletion methods.
 * <p>
 * Linked Lists are O(1) for insertion/deletion, and are stored non-contiguously in memory.
 *
 * @param <T> the data type
 */
public class SinglyLinkedList<T> implements LinkedList<T> {

    private Node<T> head;
    private int size;

    @Override
    public void insertAtIndex(int index, T object) throws IllegalArgumentException {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Cannot perform insertion at index " + index);
        }

        Node<T> insert = new Node<>(object);

        if (index == 0) {
            if (head != null) {
                insert.next = head;
            }
            head = insert;
        } else {
            Node<T> current = head;

            for (int k = 1; k < index; k++) {
                if (current == null) {
                    throw new IllegalStateException("Unexpected null node at index " + k);
                }
                current = current.next;
            }
            Node<T> temp = current.next;
            current.next = insert;
            insert.next = temp;
        }
        size++;
    }

    @Override
    public T deleteFromIndex(int index) throws IllegalArgumentException {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Cannot perform deletion at index " + index);
        }
        Node<T> deleted;

        if (index == 0) {
            deleted = head;
            head = head.next;
        } else {
            Node<T> before = head;

            for (int k = 0; k < index - 1; k++) {
                if (before.next == null) {
                    throw new IllegalStateException("Unexpected null node at index " + k);
                }
                before = before.next;
            }
            deleted = before.next;

            if (deleted != null) {
                before.next = deleted.next;
            }
        }
        size--;

        return deleted != null ? deleted.data : null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(T object) {
        Node<T> node = head;

        for (int index = 0; node != null; index++) {
            if (Objects.equals(node.data, object)) {
                return index;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public void insertFirst(T object) {
        insertAtIndex(0, object);
    }

    @Override
    public void insertLast(T object) {
        insertAtIndex(size, object);
    }

    @Override
    public T deleteFirst() throws IllegalArgumentException {
        return deleteFromIndex(0);
    }

    @Override
    public T deleteLast() throws IllegalArgumentException {
        return deleteFromIndex(size - 1);
    }

    private static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

}
