package com.example.workTestWithSpringBoot;

import com.beans.Student;
import com.example.singlottest.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@SpringBootApplication(scanBasePackages = {"com.beans"})
@EnableDiscoveryClient
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
