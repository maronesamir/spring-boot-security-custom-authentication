package com.wstutorial.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


    @RequestMapping("/")
    public String hello(){
        return "Hello World";
    }

    @RequestMapping("/protected")
    public String protectedHello(){
        return "Hello World, i was protected";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "Hello World from admin";
    }

}
