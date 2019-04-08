package com.example.reading;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HighLightServiceTest {

    private HighLightService displayService = new HighLightService();

    @Test
    @DisplayName("highlight known words in lower case")
    void highlightKnownWords_lowerCase() {
        String block = "look at that";

        String words = displayService.highlightWords(block);

        assertThat(words).isEqualTo("<mark>look</mark> <mark>at</mark> that");
    }

    @Test
    @DisplayName("highlight known words in mix case")
    void highlightKnownWords_mixCase() {
        String block = "Look AT that";

        String words = displayService.highlightWords(block);

        assertThat(words).isEqualTo("<mark>Look</mark> <mark>AT</mark> that");
    }

    @Test
    @DisplayName("highlight known words with punctuation (eg , . ! ?)")
    void highlightKnownWords_withPunctuation() {
        String block = "Look, at. that red! little?";

        String words = displayService.highlightWords(block);

        assertThat(words).isEqualTo("<mark>Look,</mark> <mark>at.</mark> that <mark>red!</mark> <mark>little?</mark>");
    }

    @Test
    @DisplayName("highlight known words where word separator is not space (eg tab, multi spaces, etc)")
    void highlightKnownWords_whereWordSeparatorIsNotSpace() {
        String block = "Look  at    that";

        String words = displayService.highlightWords(block);

        assertThat(words).isEqualTo("<mark>Look</mark> <mark>at</mark> that");
    }
}