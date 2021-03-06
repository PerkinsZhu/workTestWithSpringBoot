package com.controller;


import com.beans.Student;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by PerkinsZhu on 6/29/18 11:39 PM
 */

@Controller
@EnableAutoConfiguration
@Import({com.beans.Student.class})
@RequestMapping(value = "/springboot")
public class HelloController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String login(@RequestParam  String name,@RequestParam String pas) {
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        SecurityManager securityManager=factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        logger.info("---->" + name + "-->" + pas);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name, pas);
        subject.login(usernamePasswordToken);
        logger.info("---ok---");
        return "login";
    }

}
