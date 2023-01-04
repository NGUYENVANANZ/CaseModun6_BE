package com.example.casemodun6_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class CaseModun6BeApplication {

    public static void main(String[] args) {
        SpringApplication springApplication=new SpringApplication(CaseModun6BeApplication.class);
        System.out.println("Spring Core Version:- " + SpringVersion.getVersion());
        springApplication.run(args);
    }

}
