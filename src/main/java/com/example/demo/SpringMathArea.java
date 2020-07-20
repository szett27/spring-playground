package com.example.demo;


import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SpringMathArea{




    @PostMapping("/math/area") // matches /individual-example/foo/bar
    public String getAreaParams(@RequestParam Map<String, String> formData){

        if(formData.get("type").equals("circle")){
            if(!formData.get("radius").equals(null)){
                return ("Area of a circle with a radius of " + formData.get("radius") +  " is " + Math.PI*2*Integer.parseInt(formData.get("radius")));
            } else {
                return("INVALID");
            }
        } else if (formData.get("type").equals("rectangle")){
            if(!formData.get("width").equals(null) && !formData.get("height").equals(null)){
                return ("Area of a " + formData.get("height") +"x"+ formData.get("width") + " rectangle is " +
                        Integer.parseInt(formData.get("width")) *

                        Integer.parseInt(formData.get("height")));
            } else {
                return ("INVALID");
            }
            } else {
            return ("INVALID");
        }
        }


    }


