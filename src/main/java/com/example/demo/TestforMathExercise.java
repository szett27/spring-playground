//package com.example.demo;
//
//
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping
//public class TestforMathExercise {
//    @GetMapping("/math/calculate")
//
//    public String getString(@RequestParam("operation") String operation, @RequestParam("x") String x,
//                            @RequestParam("y") String y) {
//
////
//        String result = "";
//        int a = Integer.parseInt(x);
//        int b = Integer.parseInt(y);
//
//        if (operation.equals("add")) {
//            result = a + " + " + b + " = " + (a + b);
//        } else if (operation.equals("subtract")) {
//            result = a + " - " + b + " = " + (a - b);
//        } else if (operation.equals("multiply")) {
//            result = a + " * " + b + " = " + (a * b);
//        } else if (operation.equals("divide")) {
//            result = a + " / " + b + " = " + (a / b);
//        }
//
//        return result;
//    }
//
//        @PostMapping("/sum")
//        public String sum(@RequestParam("n") String n) {
//            return "You just POSTed to /tasks";
//        }
//
//    }
//
//
//
//
//
//}