package com.fractalwrench.structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the {@link Queue} data structure using {@link String}
 */
public class QueueTest {

    private static final int ELEMENT_COUNT = 10000;

    private Queue<String> queue;

    @Before
    public void setUp() throws Exception {
        queue = new Queue<>();
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(queue.isEmpty());
        queue.enqueue("test");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void size() throws Exception {
        assertEquals(0, queue.size());

        queue.dequeue();
        assertEquals(0, queue.size());

        queue.enqueue("test");
        queue.enqueue("test2");
        assertEquals(2, queue.size());

        queue.dequeue();
        assertEquals(1, queue.size());
    }

    @Test
    public void enqueueAndDequeue() throws Exception {
        String firstObj = "first";
        String secondObj = "second";
        String thirdObj = "third";

        queue.enqueue(firstObj);
        queue.enqueue(secondObj);

        assertEquals(firstObj, queue.dequeue());

        queue.enqueue(thirdObj);
        assertEquals(secondObj, queue.dequeue());
        assertEquals(thirdObj, queue.dequeue());
    }

    @Test
    public void testEmptyDequeue() throws Exception {
        assertNull(queue.dequeue());
    }

    /**
     * Tests the stack using a large number of objects
     */
    @Test
    public void testLargeElementUse() {
        Queue<Integer> integerQueue = new Queue<>();

        for (int k = 0; k < ELEMENT_COUNT; k++) {
            integerQueue.enqueue(k);
            assertEquals(k + 1, integerQueue.size());
        }

        assertEquals(0, (int) integerQueue.dequeue());
    }

}