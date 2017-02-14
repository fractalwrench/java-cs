package com.fractalwrench.algorithms.cci.ch2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * Cracking the Coding Interview Q2.1
 */
public class RemoveLLDuplicateSolution {

    public LinkedList<String> removeDuplicates(LinkedList<String> linkedList) {
        if (linkedList == null) {
            throw new IllegalArgumentException("Cannot remove duplicates from null LinkedList");
        }

        // elements in a set must be unique
        Set<String> elements = new HashSet<>();

        for (Iterator<String> iterator = linkedList.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();

            if (elements.contains(s)) { // found a duplicate
                iterator.remove();
            }
            else {
                elements.add(s);
            }
        }
        return linkedList;
    }

}
