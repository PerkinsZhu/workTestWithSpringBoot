package com.controller;


import com.beans.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by PerkinsZhu on 6/29/18 11:39 PM
 */

@Controller
@EnableAutoConfiguration
@Import({com.beans.Student.class})
@RequestMapping(value = "/springboot")
public class HelloController {

    @Autowired
    private Student student01;

    @Autowired
    private Student student02;

    @RequestMapping("/hello")
    @ResponseBody
    private String home() {
        Student st1 = new Student();
        Student st2 = new Student();
        System.out.println(st1);
        System.out.println(st2);
        System.out.println(student01);
        System.out.println(student02);
        return "Hello ,spring boot!";
    }


}
