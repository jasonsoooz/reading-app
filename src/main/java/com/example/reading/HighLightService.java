package com.example.reading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.String.format;

public class HighLightService {

    private List<String> words = new ArrayList<>();

    public HighLightService() {
        // Level 1: when? (9 words)
        List<String> level1 = Arrays.asList("look", "me", "at", "i", "is",
                "am", "the", "little", "on", "|");
        words.addAll(level1);

        // Level 2: when? (14 words)
        List<String> level2 = Arrays.asList("see", "red", "you", "blue",
                "dad", "are", "yellow", "said", "here", "for", "green",
                "come", "mum", "and", "|");
        words.addAll(level2);

        // Level 3: Tue 9 Apr 19 (11 words)
        List<String> level3 = Arrays.asList("up", "in", "father", "baby",
                "wake", "mother", "bed", "big", "too", "bear", "farm", "|");
        words.addAll(level3);

        // Level 4: Mon 20 May 19 (12 words)
        List<String> level4 = Arrays.asList("comes", "can", "not", "looked",
                "shouted", "cannot", "bird", "tree", "meow", "asleep",
                "hungry", "sun");
        words.addAll(level4);
    }

    public String highlightWords(String block) {
        // Split words by multiple occurrences of white space character "\s" (eg \t \n \r etc)
        String[] blockWords = block.split("\\s+");
        List<String> results = new ArrayList<>();
        for (String word : blockWords) {
            // Get rid of any non word characters
            String wordWithoutPunctuation = word.replaceAll("\\W", "");
            if (words.contains(wordWithoutPunctuation.toLowerCase())) {
                results.add(format("%s%s%s","<mark>", word, "</mark>"));
            } else {
                results.add(word);
            }
        }
        return String.join(" ", results);
    }

    public String getKnownWords() {
        return String.join(" ", words);
    }

    public int getKnownWordsSizeMinusDelimiters() {
        // Remove number of delimiters (for making words in a week)
        int numberOfDelimiters = Collections.frequency(words, "|");
        return words.size() - numberOfDelimiters;
    }
}
