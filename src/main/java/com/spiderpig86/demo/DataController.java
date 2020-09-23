package com.spiderpig86.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    private DataFacade dataFacade;

    @RequestMapping("/getstrings")
    private List<String> getWord() {
        return dataFacade.getWords();
    }

    @PostMapping("/addstring")
    private List<String> addWordEndpoint(@RequestBody String word) {
        return dataFacade.addWord(word);
    }

    @RequestMapping("/increment")
    private int incrementEndpoint() {
        return dataFacade.increment();
    }

    @PostMapping("/reset")
    private void resetEndpoint() {
        this.dataFacade.reset();
    }
}
