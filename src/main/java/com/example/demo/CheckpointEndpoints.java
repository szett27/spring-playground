package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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


    //checkpoint #3 - Encode
    @PostMapping("/encode")
    public String encode(@RequestParam Map<String, String> formData){
        String[] original = formData.get("original").split(" ");
        String encoder = formData.get("key");
        String abcs = "abcdefghijklmnopqrstuvwzyz";
        Map<String, String> coder = null;
        String encoded = "";


        //Map Abcs to encoder
        for(int i  = 0; i<abcs.length();i++){
            for(int j = 0; j < encoder.length(); j++){
                coder.put(abcs.substring(i), encoder.substring(j));
            }
        }

        //encode string
        for(String word: original){
            String[] letters = word.split("");
            for(int k =0; k < letters.length; k++) {
                //coded value
                letters[k] = coder.get(word.substring(k));
            }
            encoded += String.join("", letters);
        }
        return encoded;
    }

    //checkpoint #4 - SED
    @PostMapping("/s/{find}/{replacement}")
    public String replace(@PathVariable("find") String find,
                          @PathVariable("replacement") String replacement,
                          @RequestBody String body){

        String replaced = "";
        String[] split = body.split(" ");

        for(String word: split){
            if(word.equals(find)){
                word = replacement;
            }
        }

        replaced = String.join(" ", split);


        return replaced;
    }




}
