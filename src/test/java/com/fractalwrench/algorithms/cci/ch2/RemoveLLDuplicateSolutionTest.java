package com.fractalwrench.algorithms.cci.ch2;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RemoveLLDuplicateSolutionTest {

    private LinkedList<String> linkedList;
    private RemoveLLDuplicateSolution solution;

    @Before
    public void setUp() throws Exception {
        linkedList = new LinkedList<>();
        solution = new RemoveLLDuplicateSolution();
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullCase() throws Exception {
        solution.removeDuplicates(null);
    }

    @Test
    public void emptyCase() throws Exception {
        assertEquals(linkedList, solution.removeDuplicates(linkedList));
    }

    @Test
    public void noDuplicates() throws Exception {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        assertEquals(linkedList, solution.removeDuplicates(linkedList));
    }

    @Test
    public void duplicateRemoval() throws Exception {
        String firstData = "test1";
        String secondData = "Another Test";
        String thirdData = "More strings!±";

        linkedList.add(firstData);
        linkedList.add(firstData);
        linkedList.add(secondData);
        linkedList.add(firstData);
        linkedList.add(thirdData);
        linkedList.add(firstData);

        List<String> strings = Arrays.asList(firstData, secondData, thirdData);
        LinkedList<String> expected = new LinkedList<>(strings);
        assertEquals(expected, solution.removeDuplicates(linkedList));
    }

}