package com.example.workTestWithSpringBoot;

import com.beans.Student;
import com.example.singlottest.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@SpringBootApplication(scanBasePackages = {"com.beans"})
public class WorkTestWithSpringBootApplication {

    public static void main(String[] args) {
//		SpringApplication.run(WorkTestWithSpringBootApplication.class, args);
        SpringApplication.run(HelloController.class, args);
    }
}
