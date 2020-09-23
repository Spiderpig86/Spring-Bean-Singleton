package com.spiderpig86.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("singleton")
public class DataFacade {

    private volatile List<String> words;
    private volatile int counter;

    public DataFacade() {
        this.words = Collections.synchronizedList(new ArrayList<>());
        this.counter = 0;
    }

    public List<String> getWords() {
        return this.words;
    }

    public synchronized List<String> addWord(final String word) throws InterruptedException {
        this.words = Collections.synchronizedList(new ArrayList<>());
        this.words.add(word);

        // Do some work and return list, we should only return one word (the word originally requested)...
        Thread.sleep(1000);

        return this.words;
    }

    public synchronized int increment() {
        return ++this.counter;
    }

    public void reset() {
        this.words = new ArrayList<>();
        this.counter = 0;
    }
}
