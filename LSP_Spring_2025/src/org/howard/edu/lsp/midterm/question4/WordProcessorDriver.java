package org.howard.edu.lsp.midterm.question4;
//References used:
//https://www.geeksforgeeks.org/
//https://www.programiz.com/

import java.util.List;

/**
 * The WordProcessorDriver class is used to test the functionality of the WordProcessor class.
 * It demonstrates the behavior of finding the longest words in a sentence using various test cases.
 */
public class WordProcessorDriver {
    public static void main(String[] args) {
        // Test case 1: Sentence with a single longest word (ignoring punctuation as per requirements)
        WordProcessor wp1 = new WordProcessor("This is a test with amazing results amazing achievements");
        List<String> longestWords1 = wp1.findLongestWords();
        System.out.println("Test 1 - Longest words: " + longestWords1);
        
        // Test case 2: Sentence with multiple occurrences of the same longest word and length
        WordProcessor wp2 = new WordProcessor("Java is a powerful  tool");
        List<String> longestWords2 = wp2.findLongestWords();
        System.out.println("Test 2 - Longest words: " + longestWords2);
        
        // Test case 3: Sentence with single character words
        WordProcessor wp3 = new WordProcessor("A B C D E");
        List<String> longestWords3 = wp3.findLongestWords();
        System.out.println("Test 3 - Longest words: " + longestWords3);
        
        // Test case 4: Empty string input
        WordProcessor wp4 = new WordProcessor("");
        List<String> longestWords4 = wp4.findLongestWords();
        System.out.println("Test 4 - Longest words: " + longestWords4);
    }
}