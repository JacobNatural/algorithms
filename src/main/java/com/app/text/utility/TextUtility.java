package com.app.text.utility;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class with tools for handling text
 */
public interface TextUtility {
    /**
     * Check if two text are anagram
     * @param txt1 first text
     * @param txt2 second text
     * @return true if text are anagram
     */
    static boolean isAnagram(String txt1, String txt2){

        if(txt1 == null){
            throw new IllegalArgumentException("Text 1 is null");
        }

        if(txt2 == null){
            throw new IllegalArgumentException("Text 2 is null");
        }

        if(txt1.isEmpty()){
            throw new IllegalArgumentException("Text 1 is empty");
        }

        if(txt2.isEmpty()){
            throw new IllegalArgumentException("Text 2 is empty");
        }

        if(txt1.length() != txt2.length()){
            return false;
        }

        var arrChar1 = txt1.toCharArray();
        var arrChar2 = txt2.toCharArray();

        Arrays.sort(arrChar1);
        Arrays.sort(arrChar2);

        return Arrays.equals(arrChar1, arrChar2);

    }
    /**
     * Check if text is palindrome
     * @param txt text
     * @return true if text is palindrome
     */
    static boolean isPalindrome(String txt){
        if(txt == null){
            throw new IllegalArgumentException("Text is null");
        }

        if(txt.isEmpty()){
            throw new IllegalArgumentException("Text is empty");
        }
        return  new StringBuilder(txt
                .toLowerCase()
                .replaceAll("[^a-z0-9]",""))
                .reverse()
                .toString()
                .equals(txt.toLowerCase().replaceAll("[^a-z0-9]",""));
    }
    /**
     * Check if is in text the pattern
     * @param txt text
     * @param pattern pattern for searching
     * @return true if pattern is in text
     */

    static boolean isPattern(String txt, String pattern){

        if(txt == null){
            throw new IllegalArgumentException("Text is null");
        }

        if(pattern == null){
            throw new IllegalArgumentException("Pattern is null");
        }

        if(txt.isEmpty()){
            throw new IllegalArgumentException("Text is empty");
        }

        if(pattern.isEmpty()){
            throw new IllegalArgumentException("Pattern is empty");
        }

        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(txt);

        return matcher.find();
    }
}
