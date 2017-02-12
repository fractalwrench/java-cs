package com.fractalwrench.algorithms.cci.ch1;

public class StringCompressionSolution {

    /**
     * Compresses a string by replacing repeated characters with their count
     *
     * @param input the input
     * @return the compressed string
     * @throws IllegalArgumentException if the input is null
     */
    public String compressString(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("Cannot use null param supplied");
        }
        if (input.length() == 0) {
            return input;
        }

        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        int consecutiveCount = 1;

        for (int k = 1; k < chars.length; k++) {
            if (chars[k - 1] == chars[k]) {
                consecutiveCount++;
            } else {
                appendToSb(chars[k - 1], sb, consecutiveCount);
                consecutiveCount = 1;
            }
        }
        appendToSb(chars[chars.length - 1], sb, consecutiveCount);

        String s = sb.toString();
        if (s.length() < input.length()) {
            return s;
        }
        else {
            return input;
        }
    }

    private static void appendToSb(char aChar, StringBuilder sb, int consecutiveCount) {
        sb.append(aChar);
        sb.append(consecutiveCount);
    }

}
