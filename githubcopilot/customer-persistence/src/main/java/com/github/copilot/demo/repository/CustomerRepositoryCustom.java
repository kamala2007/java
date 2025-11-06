package com.github.copilot.demo.repository;

import com.github.copilot.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerRepositoryCustom {
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Adds a new customer to the H2 database.
     * @param name Customer name
     * @param email Customer email
     * @return The saved Customer entity
     */
    public Customer addCustomer(String name, String email) {
        Customer customer = new Customer(name, email);
        return customerRepository.save(customer);
    }

    /**
     * Retrieves all customers from the H2 database.
     * @return List of all customers
     */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Retrieves a customer by ID from the H2 database.
     * @param id Customer ID
     * @return The Customer entity, or null if not found
     */
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
