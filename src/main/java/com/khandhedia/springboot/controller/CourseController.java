package com.khandhedia.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {


    @RequestMapping("/hi")
    public String  hi()
    {
        return "hi";
    }

}

