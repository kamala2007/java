package com.github.copilot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.github.copilot.demo.model.Customer;
import com.github.copilot.demo.repository.CustomerRepository;

@SpringBootApplication
public class CustomerApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(new Customer("Alice", "alice@example.com"));
            customerRepository.save(new Customer("Bob", "bob@example.com"));
            customerRepository.save(new Customer("Charlie", "charlie@example.com"));
        };
    }
}

