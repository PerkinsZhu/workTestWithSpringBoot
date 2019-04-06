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
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by PerkinsZhu on 6/29/18 11:39 PM
 */

@Controller
@EnableAutoConfiguration
@Import({Student.class})
public class MongoController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String login(@RequestParam  String name,@RequestParam String pas) {
        Subject subject = SecurityUtils.getSubject();
        logger.info("---->" + name + "-->" + pas);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name, pas);
        subject.login(usernamePasswordToken);
        logger.info("---ok---");
        return "login";
    }

}
