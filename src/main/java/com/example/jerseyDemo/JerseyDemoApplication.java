package com.example.jerseyDemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
 
@SpringBootApplication
public class JerseyDemoApplication extends SpringBootServletInitializer 
{
    public static void main(String[] args) 
    {
        new JerseyDemoApplication().configure(new SpringApplicationBuilder(JerseyDemoApplication.class)).run(args);
    }
}