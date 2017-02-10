package com.fractalwrench.structures;

/**
 * Builds a string out of multiple strings, holding it internally in a
 * dynamically resized char array.
 * Unlike string concatenation, this avoids the creation of new objects, and is a more efficient
 * in terms of Big O-notation.
 */
public class StringBuilder {

    public static final int DEFAULT_CAPACITY = 32;

    private int size;
    private char[] values;

    public StringBuilder() {
        this.values = new char[DEFAULT_CAPACITY];
    }

    /**
     * Appends a {@link CharSequence} to the internal buffer.
     *
     * @param str the string to append
     * @throws IllegalArgumentException - if the argument is null
     */
    public void append(CharSequence str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("Cannot append a null CharSequence!");
        }
        int len = str.length();
        int newSize = size + len;

        if (newSize > values.length) {
            increaseCapacity();
        }

        for (int k = 0; k < len; k++) {
            values[size + k] = str.charAt(k);
        }
        size += len;
    }

    private void increaseCapacity() {
        int newCapacity = values.length * 2;
        char[] newValues = new char[newCapacity];

        // manual array copy - should use java stdlib in Production
        //noinspection ManualArrayCopy
        for (int k = 0; k < values.length; k++) {
            newValues[k] = values[k];
        }
        values = newValues;
    }

    @Override
    public String toString() {
        return new String(values, 0, size);
    }

    /**
     * Retrieves the capacity of the current char buffer
     *
     * @return the capacity
     */
    public int getCapacity() {
        return values.length;
    }

    /**
     * Retrieves the size of the buffer
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Clears the buffer of any characters it is holding
     */
    public void clear() {
        for (int k = 0; k < values.length; k++) {
            values[k] = '\0'; // default to null terminator
        }
        size = 0;
    }

}
