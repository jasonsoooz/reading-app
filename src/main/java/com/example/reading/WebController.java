package com.example.reading;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    private HighLightService displayService = new HighLightService();

    private int size = displayService.getKnownWordsSizeMinusDelimiters();
    private String knownWords = displayService.getKnownWords();

    @GetMapping(value = "/read")
    public String display(Model model) {
        addToModelKnownWordsAndSize(model);
        model.addAttribute("block", new BlockDTO());
        return "read";
    }

    @PostMapping(value = "/read")
    public String highlight(@ModelAttribute("block") BlockDTO block, Model model) {
        String result = displayService.highlightWords(block.getWords());
        addToModelKnownWordsAndSize(model);
        model.addAttribute("result", result);
        return "read";
    }

    private void addToModelKnownWordsAndSize(Model model) {
        model.addAttribute("knownWords", knownWords);
        model.addAttribute("size", size);
    }
}
