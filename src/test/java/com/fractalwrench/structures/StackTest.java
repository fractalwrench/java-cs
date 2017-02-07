package com.fractalwrench.structures;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests the {@link Stack} data structure using {@link String}
 */
@RunWith(JUnit4.class)
public class StackTest {

    private static final int ELEMENT_COUNT = 10000;
    private Stack<String> stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<>();
    }

    /**
     * Ensures that the number of elements on the stack is calculated correctly
     */
    @Test
    public void testPopPeekPushSize() throws Exception {
        assertEquals(0, stack.size());
        String data = "test";
        stack.push(null);
        stack.push(data);
        assertEquals(2, stack.size());

        assertEquals(data, stack.peek());
        assertEquals(2, stack.size());

        assertEquals(data, stack.pop());
        assertEquals(1, stack.size());

        stack.pop();
        assertEquals(0, stack.size());
    }

    /**
     * Ensures that popping an empty stack throws an exception
     */
    @Test(expected = IllegalStateException.class)
    public void emptyPop() throws Exception {
        stack.pop();
    }

    /**
     * Ensures that peeking an empty stack throws an exception
     */
    @Test(expected = IllegalStateException.class)
    public void emptyPeek() throws Exception {
        stack.peek();
    }

    /**
     * Ensures that the stack returns true if it has no objects
     */
    @Test
    public void isEmpty() throws Exception {
        assertTrue(stack.isEmpty());
        stack.push("");
        assertFalse(stack.isEmpty());
    }

    /**
     * Tests the stack using a large number of objects
     */
    @Test
    public void testLargeElementUse() {
        Stack<Integer> integerStack = new Stack<>();

        for (int k = 0; k < ELEMENT_COUNT; k++) {
            integerStack.push(k);
        }

        assertEquals(ELEMENT_COUNT, integerStack.size());
        assertEquals(ELEMENT_COUNT - 1, (int) integerStack.peek());
        assertEquals(ELEMENT_COUNT - 1, (int) integerStack.pop());
        assertEquals(ELEMENT_COUNT - 1, (int) integerStack.size());
    }

}