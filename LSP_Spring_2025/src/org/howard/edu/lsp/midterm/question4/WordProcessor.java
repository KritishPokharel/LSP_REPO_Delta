package org.howard.edu.lsp.midterm.question4;
//References used:
//https://www.geeksforgeeks.org/
//https://www.programiz.com/

import java.util.ArrayList;
import java.util.List;

/**
 * The WordProcessor class processes a sentence and extracts all the longest words.
 * It assumes that the input sentence does not contain any punctuation and may include varying whitespace.
 */
public class WordProcessor {
    private String sentence;

    /**
     * Constructs a WordProcessor with the given sentence.
     *
     * @param sentence the sentence to process.
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds and returns all the words in the sentence that have the maximum length.
     * <p>
     * The method splits the sentence on one or more whitespace characters, determines the maximum word length,
     * and then collects all words of that length in the order in which they appear in the sentence.
     * If the sentence is empty or contains no words, an empty list is returned.
     * </p>
     *
     * @return a list of the longest word(s) in their original order.
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords;
        }

        // Split on one or more whitespace characters
        String[] words = sentence.trim().split("\\s+");
        int maxLength = 0;
        
        // Determine the maximum length
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        
        // Collect all words that match the maximum length
        for (String word : words) {
            if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }
        
        return longestWords;
    }
}