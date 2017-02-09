package com.fractalwrench.structures;

public class SinglyLinkedList<T> implements LinkedList<T> {

    private Node<T> first;
    private int size;

    @Override
    public void insertFirst(T object) {
        insertAtIndex(0, object);
    }

    @Override
    public void insertLast(T object) {

    }

    @Override
    public T deleteFirst() throws IllegalArgumentException {
        return null;
    }

    @Override
    public T deleteLast() throws IllegalArgumentException {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int indexOf(T object) {
        return 0;
    }

    @Override
    public void insertAtIndex(int index, T object) throws IllegalArgumentException {

    }

    @Override
    public T deleteFromIndex(int index) throws IllegalArgumentException {
        return null;
    }

    private static class Node<T> {

    }

}
