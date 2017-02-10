package com.fractalwrench.structures;

/**
 * A custom implementation of a List backed by a dynamically resized array.
 *
 * @param <T> the type of data
 */
@SuppressWarnings("ALL")
public class ArrayList<T> {

    public static final int DEFAULT_CAPACITY = 32;

    private int size;

    // Use Object because type erasure prevents dynamic instantiation of generic arrays
    private Object[] values;

    public ArrayList() {
        this.values = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Adds the given object to the last position in the array
     *
     * @param object the object
     */
    public void add(T object) {
        if (size >= values.length) {
            increaseCapacity();
        }
        values[size] = object;
        size++;
    }

    private void increaseCapacity() {
        int newCapacity = values.length * 2;
        Object[] newValues = new Object[newCapacity];

        for (int k = 0; k < values.length; k++) {
            newValues[k] = values[k];
        }
        values = newValues;
    }

    /**
     * Deletes the given object from the first position it is found in the array
     *
     * @param object the object
     * @return the object, or null if not found
     */
    public T delete(T object) {
        int index = indexOf(object);

        if (index == -1) {
            return null;
        } else {
            T item = (T) values[index];

            for (int k = index, len = values.length; k < len - 1; k++) {
                int next = k + 1;
                values[k] = values[next];
            }
            values[size - 1] = null; // remove last item
            size--;
            return item;
        }
    }

    /**
     * Clears the array of all objects
     */
    public void clear() {
        values = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Determines whether the list contains objects or not
     *
     * @return true if no objects, otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Determines the size of the array buffer backing the list
     *
     * @return the number of objects
     */
    public int size() {
        return size;
    }

    public int getCapacity() {
        return values.length;
    }

    /**
     * Returns the first index of the given object, or -1 if it is not in the list
     *
     * @param object the object
     * @return the object's first index or -1
     */
    public int indexOf(T object) {
        for (int k = 0; k < values.length; k++) {
            Object value = values[k];
            if ((value == null && object == null) || object.equals(value)) {
                return k;
            }
        }
        return -1;
    }

}
