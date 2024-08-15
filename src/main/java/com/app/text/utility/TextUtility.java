package com.app.text.utility;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides utility methods for text processing, including checking for anagrams, palindromes, and pattern matching.
 */
public interface TextUtility {

    /**
     * Determines if two strings are anagrams of each other.
     * Two strings are considered anagrams if they contain the same characters with the same frequencies,
     * but the order of characters may be different.
     *
     * @param txt1 the first string to compare
     * @param txt2 the second string to compare
     * @return true if the two strings are anagrams, false otherwise
     * @throws IllegalArgumentException if either of the strings is null or empty, or if they have different lengths
     */
    static boolean isAnagram(String txt1, String txt2) {
        if (txt1 == null) {
            throw new IllegalArgumentException("Text 1 is null");
        }

        if (txt2 == null) {
            throw new IllegalArgumentException("Text 2 is null");
        }

        if (txt1.isEmpty()) {
            throw new IllegalArgumentException("Text 1 is empty");
        }

        if (txt2.isEmpty()) {
            throw new IllegalArgumentException("Text 2 is empty");
        }

        if (txt1.length() != txt2.length()) {
            return false;
        }

        var arrChar1 = txt1.toCharArray();
        var arrChar2 = txt2.toCharArray();

        Arrays.sort(arrChar1);
        Arrays.sort(arrChar2);

        return Arrays.equals(arrChar1, arrChar2);
    }

    /**
     * Checks if a string is a palindrome. A palindrome reads the same forward and backward when non-alphanumeric
     * characters are ignored, and case is disregarded.
     *
     * @param txt the string to check
     * @return true if the string is a palindrome, false otherwise
     * @throws IllegalArgumentException if the string is null or empty
     */
    static boolean isPalindrome(String txt) {
        if (txt == null) {
            throw new IllegalArgumentException("Text is null");
        }

        if (txt.isEmpty()) {
            throw new IllegalArgumentException("Text is empty");
        }

        return new StringBuilder(txt
                .toLowerCase()
                .replaceAll("[^a-z0-9]", ""))
                .reverse()
                .toString()
                .equals(txt.toLowerCase().replaceAll("[^a-z0-9]", ""));
    }

    /**
     * Checks if a string contains a substring that matches a given regular expression pattern.
     *
     * @param txt     the string to search
     * @param pattern the regular expression pattern to match
     * @return true if the pattern is found in the string, false otherwise
     * @throws IllegalArgumentException if either the string or the pattern is null or empty
     */
    static boolean hasPattern(String txt, String pattern) {
        if (txt == null) {
            throw new IllegalArgumentException("Text is null");
        }

        if (pattern == null) {
            throw new IllegalArgumentException("Pattern is null");
        }

        if (txt.isEmpty()) {
            throw new IllegalArgumentException("Text is empty");
        }

        if (pattern.isEmpty()) {
            throw new IllegalArgumentException("Pattern is empty");
        }

        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(txt);

        return matcher.find();
    }
}
