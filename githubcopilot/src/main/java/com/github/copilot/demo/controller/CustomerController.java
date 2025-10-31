package com.github.copilot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/getCustomer")
    public String getCustomer() {
        return "Customer details";
    }
}