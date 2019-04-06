package com;

import com.beans.Student;
import com.controller.HelloController;
import com.controller.LoginResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages = {"com"})
public class WorkTestWithSpringBootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        // SpringApplication.run(WorkTestWithSpringBootApplication.class, args);
        SpringApplication.run(HelloController.class, args);
    }


    @Override   //为了打包springboot项目
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
