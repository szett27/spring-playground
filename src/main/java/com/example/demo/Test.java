package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Test {
    @GetMapping("/math/pi")
    public String getPi() {
        return "3.141592653589793";
    }
}
