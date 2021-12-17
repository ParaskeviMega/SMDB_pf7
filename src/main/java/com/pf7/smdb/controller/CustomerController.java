package com.pf7.smdb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/")
    public String sayHello(){
        return "1.GetCustomer \n 2.GetProduct \n 3.GetClient";

    }
}
