package com.fractalwrench.structures;

/**
 * A custom implementation of a Hash Table, which maps keys to values using their hashcodes.
 * Lookup of an individual item is O(1).
 * <p>
 * N.B. this structure does not account for Hash Collisions - this could be fixed by
 * using a {@link java.util.LinkedList} for each array's element
 *
 * @param <K> the key type
 * @param <V> the value type
 */
@SuppressWarnings("unchecked")
public class HashTable<K, V> {

    private static final int DEFAULT_CAPACITY = 128;

    private V[] values;

    public HashTable() {
        clear();
    }

    /**
     * Adds a value to the map with the given key
     *
     * @param key   the key
     * @param value the value
     * @throws IllegalArgumentException if the key is null
     */
    public void put(K key, V value) throws IllegalArgumentException {
        checkForNullKey(key);
        int index = getIndexForKey(key);
        values[index] = value;
    }

    /**
     * Retrieves the value mapped with the given key
     *
     * @param key the key
     * @return the value, or null if not present
     * @throws IllegalArgumentException if the key is null
     */
    public V get(K key) {
        checkForNullKey(key);
        int index = getIndexForKey(key);
        return values[index];
    }

    /**
     * Removes the value mapped with the given key
     *
     * @param key the key
     * @return the removed value
     * @throws IllegalArgumentException if the key is null
     */
    public V remove(K key) {
        checkForNullKey(key);
        int index = getIndexForKey(key);
        V value = values[index];
        values[index] = null;
        return value;
    }

    /**
     * Clears all values from the map
     */
    public void clear() {
        values = (V[]) new Object[DEFAULT_CAPACITY];
    }

    private void checkForNullKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Cannot use null key");
        }
    }

    private int getIndexForKey(K key) {
        return key.hashCode() % DEFAULT_CAPACITY;
    }
}
