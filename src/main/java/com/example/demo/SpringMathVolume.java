package com.example.demo;


import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringMathVolume{


        @GetMapping("/math/volume/{l}/{w}/{h}") // matches /individual-example/foo/bar
        public String getIndividualParams(@PathVariable("l") String length, @PathVariable("w") String width,
             @PathVariable("h") String height){

            return ("The volume of a " + length + "x" + width + "x" + height + " rectangle is "
            + Integer.parseInt(length) * Integer.parseInt(width) * Integer.parseInt(height));
        }

    }


