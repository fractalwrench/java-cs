package com.fractalwrench.algorithms.cci.ch3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class SortStackSolutionTest {

    private static final int[] ARY_INPUT = {5, 3, 6, 6, -2, 17, 9};
    private static final int[] ARY_OUTPUT = {-2, 3, 5, 6, 6, 9, 17};

    private SortStackSolution solution;

    @Before
    public void setUp() throws Exception {
        solution = new SortStackSolution();
    }

    @Test
    public void emptyCase() throws Exception {
        Stack<Integer> stack = new Stack<>();
        solution.sortStackInPlace(stack);
        assertEquals(new Stack<>(), stack);
    }

    @Test
    public void sortStackInPlace() throws Exception {
        Stack<Integer> stack = new Stack<>();

        for (int i : ARY_INPUT) {
            stack.push(i);
        }

        solution.sortStackInPlace(stack);

        for (int i : ARY_OUTPUT) {
            Assert.assertEquals(i, (int) stack.pop());
        }
    }

}