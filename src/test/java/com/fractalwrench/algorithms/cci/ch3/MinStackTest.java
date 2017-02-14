package com.fractalwrench.algorithms.cci.ch3;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;

public class MinStackTest {

    private MinStack stack;

    @Before
    public void setUp() throws Exception {
        stack = new MinStack();
    }

    @Test(expected = EmptyStackException.class)
    public void emptyCase() throws Exception {
        stack.min();
    }

    @Test
    public void testMin() throws Exception {
        stack.push(5);
        assertEquals(5, (int) stack.min());

        stack.push(7);
        assertEquals(5, (int) stack.min());

        stack.push(3);
        assertEquals(3, (int) stack.min());

        stack.pop();
        assertEquals(5, (int) stack.min());

        stack.pop();
        assertEquals(5, (int) stack.min());
    }

}