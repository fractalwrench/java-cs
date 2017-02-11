package com.fractalwrench.algorithms.cci.ch1;

import java.util.HashMap;
import java.util.Map;

/**
 * Cracking the Coding Interview Q1.1
 */
public class UniqueStringSolution {

    /**
     * Determine whether a string consists solely of unique characters.

     * @param input the string
     * @return true if unique chars, otherwise fals
     */
    public boolean hasAllUniqueChars(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("Cannot check null input");
        }

        char[] chars = input.toCharArray();
        Map<Character, Character> map = new HashMap<>();

        for (char c : chars) {
            if (map.containsKey(c)) {
                if (Character.valueOf(c).equals(map.get(c))) { // ensure there isn't a hash collision
                    return false;
                }
            }
            else {
                map.put(c, c);
            }
        }
        return true;
    }

}
