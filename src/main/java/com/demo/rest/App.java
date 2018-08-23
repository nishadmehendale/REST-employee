package com.demo.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.rest.hello.customer.ServiceImpl;
import com.demo.rest.pojo.Employee;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    
    @Bean
    public CommandLineRunner demo(ServiceImpl service) {
    	return (args) -> {
    		service.save(new Employee("Nid", 101));
    		service.save(new Employee("Nishad", 102));
    		service.save(new Employee("Sayali", 103));
    		service.save(new Employee("Drishti", 104));
    		System.out.println("Datatatta");
    	};
    }
    }
