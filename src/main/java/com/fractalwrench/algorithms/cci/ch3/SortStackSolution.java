package com.fractalwrench.algorithms.cci.ch3;

import java.util.Stack;

/**
 * Cracking the Coding Interview Q3.5
 */
public class SortStackSolution {

    private static final int MIN_SORT_SIZE = 2;

    /**
     * Sorts a stack so that the smallest items are at the top of the stack.
     *
     * @param originalStack the stack
     */
    public void sortStackInPlace(Stack<Integer> originalStack) {
        if (originalStack.size() < MIN_SORT_SIZE) {
            return;
        }

        // General approach - order everything on a temporary stack
        //
        // 1. Pop from originalStack
        // 2. If value less than temp#peek(), pop from tempStack and push to originalStack
        // 3. If originalStack empty, repopulate with contents of tempStack

        Stack<Integer> tempStack = new Stack<>();

        while (!originalStack.isEmpty()) {
            Integer value = originalStack.pop();

            if (tempStack.isEmpty() || tempStack.peek() <= value) {
                tempStack.push(value);
            }
            else {
                originalStack.push(tempStack.pop());
                originalStack.push(value);
            }
        }

        // tempStack is now reverse ordered, so simply pop back onto originalStack

        while (!tempStack.isEmpty()) {
            originalStack.push(tempStack.pop());
        }

        // 5
        // 3
        // 6
        // -2
        // 17
        // 9

    }
}
