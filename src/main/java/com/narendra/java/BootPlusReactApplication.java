package com.narendra.java;

import com.narendra.java.pojo.Owner;
import com.narendra.java.repository.CarRepository;
import com.narendra.java.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.narendra.java.pojo.Car;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootPlusReactApplication {

    @Autowired
    private CarRepository repository;

    @Autowired
    private OwnerRepository orepository;

    @SpringBootApplication
    public static class Application extends SpringBootServletInitializer {

        @Override
        protected SpringApplicationBuilder configure
                (SpringApplicationBuilder application) {
            return application.sources (Application.class);
        }

        public static void main(String[] args) throws Exception {
            SpringApplication.run (Application.class, args);
        }
    }


    @Bean
    CommandLineRunner runner() {
        return args -> {

            // Add owner objects and save these to db
            Owner owner1 = new Owner ("Narendra", "Raghuwanshi");
            Owner owner2 = new Owner ("KT", "Sinha");
            orepository.save (owner1);
            orepository.save (owner2);

            // Save demo data to database
            repository.save (new Car ("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, "Dabba", owner1));
            repository.save (new Car ("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, "Dabba", owner2));
            repository.save (new Car ("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, "Dabba", owner1));

        };

    }
}
