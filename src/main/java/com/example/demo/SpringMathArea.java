package com.example.demo;


import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringMathArea{




    @PostMapping("/math/area/?type={type}&radius={radius}&width={width}&height={height}") // matches /individual-example/foo/bar
    public String getIndividualParams(@RequestParam("type") String type, @RequestParam("radius") String radius,@RequestParam("width") String width,
                                      @RequestParam("height") String height){

        if(type.equals("circle")){
            if(!radius.equals(null)){
                return ("Area of a circle with a radius of " + radius +  " is " + Math.PI*2*Integer.parseInt(radius));
            } else {
                return("INVALID");
            }
        } else if (type.equals("rectangle")){
            if(!width.equals(null) && !height.equals(null)){
                return ("Area of a " + height +"x"+ width + " rectangle is " + Integer.parseInt(width) * Integer.parseInt(height));
            } else {
                return ("INVALID");
            }
            } else {
            return ("INVALID");
        }
        }


    }


