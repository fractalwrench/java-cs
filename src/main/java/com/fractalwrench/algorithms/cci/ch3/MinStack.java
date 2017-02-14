package com.fractalwrench.algorithms.cci.ch3;

import java.util.Stack;

/**
 * Cracking the Coding Interview Q3.2
 */
public class MinStack extends Stack<Integer> {

    private final Stack<NodeWithMin> minStack = new Stack<>();

    @Override
    public Integer push(Integer item) {
        if (minStack.isEmpty()) {
            minStack.push(new NodeWithMin(item, item));
        }
        else {
            Integer currentMin = minStack.peek().minimum;
            Integer newMin = item < currentMin ? item : currentMin;
            minStack.push(new NodeWithMin(newMin, item));
        }
        return super.push(item);
    }

    @Override
    public synchronized Integer pop() {
        minStack.pop();
        return super.pop();
    }

    public Integer min() {
        return minStack.peek().minimum;
    }

    private static class NodeWithMin {
        private final Integer minimum;
        private final Integer data;

        public NodeWithMin(Integer minimum, Integer data) {
            this.minimum = minimum;
            this.data = data;
        }
    }

}
