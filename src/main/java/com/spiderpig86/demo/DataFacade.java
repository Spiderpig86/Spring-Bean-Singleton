package com.spiderpig86.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class DataFacade {

    private List<String> words;
    private int counter;

    public DataFacade() {
        this.words = new ArrayList<>();
        this.counter = 0;
    }

    public List<String> getWords() {
        return this.words;
    }

    public List<String> addWord(final String word) {
        this.words.add(word);
        return this.words;
    }

    public int increment() {
        return ++this.counter;
    }

    public void reset() {
        this.words = new ArrayList<>();
        this.counter = 0;
    }
}
