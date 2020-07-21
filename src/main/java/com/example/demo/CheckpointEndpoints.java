package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckpointEndpoints {

    //checkpoint #1 - Camelize

    @GetMapping("/camelize")
    public String getCamel(@RequestParam("original") String original,
                           @RequestParam(value = "initialCap", required = false) boolean Cap) {
        String cameled = "";
        String[] splitString = original.split("_");

        if (Cap == true) {
            for (int i = 0; i < splitString.length; i++) {
                splitString[i] = splitString[i].substring(0, 1).toUpperCase() + splitString[i].substring(1).toLowerCase();
            }
        } else {
            for (int i = 1; i < splitString.length; i++) {
                splitString[i] = splitString[i].substring(0, 1).toUpperCase() + splitString[i].substring(1).toLowerCase();
            }
        }

        cameled = String.join("", splitString);

        return cameled;
    }


    //checkpoint #2 - Redact
    @GetMapping("/redact")
    public String redact(@RequestParam(value = "original", required = true) String original,
                         @RequestParam(value = "badWord") List<String> badwords) {
        String redacted = "";
        String[] sentence = original.split(" ");
        for(String word: badwords){
            for(int j =0; j < sentence.length; j++){
                if(sentence[j].equals(word)){
                    String redact = "";
                    for(int i =0; i < word.split("").length; i++){
                        redact += "*";
                    }
                    sentence[j] = redact;

                }

            }
        }

        redacted = String.join(" ", sentence);
        return redacted;
    }

}
