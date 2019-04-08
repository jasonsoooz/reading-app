package com.example.reading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.String.format;

public class HighLightService {

    private List<String> words = new ArrayList<>();

    public HighLightService() {
        List<String> week1 = Arrays.asList("look", "me", "at", "i", "is",
                "am", "the", "little", "on", "|");
        words.addAll(week1);

        List<String> week2 = Arrays.asList("see", "red", "you", "blue",
                "dad", "are", "yellow", "said", "here", "for", "green",
                "come", "mum", "and");
        words.addAll(week2);
    }

    public String highlightWords(String block) {
        String[] blockWords = block.split(" ");
        List<String> results = new ArrayList<>();
        for (String word : blockWords) {
            if (words.contains(word.toLowerCase())) {
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
