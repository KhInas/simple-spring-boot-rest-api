package com.example.demo.controllers;


import com.example.demo.dto.AddCustomer;
import com.example.demo.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.CustomerServices;

import java.util.List;

@RestController
@RequestMapping("/api/customer")


public class CustomerController {


    private final CustomerServices customerServices;

    @Autowired
    public CustomerController(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"applicaton/json"})
    public List<Customer>getAll(){
        return customerServices.getAll();
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST,produces = {"application/json"})
    public  Customer add(@RequestBody AddCustomer addCustomer){
        return customerServices.addCustomer(addCustomer, null);

    }
@RequestMapping(value = "/{id}", method  = RequestMethod.DELETE, produces = {"application/json"})
public Boolean delete(@PathVariable long id){
        return customerServices.deleteCustomer(id);

}
    @RequestMapping(value = "/{id}", method  = RequestMethod.PUT, produces = {"application/json"})
    public Customer edit (@RequestBody AddCustomer addCustomer, @PathVariable Long id){
        return customerServices.addCustomer(addCustomer, id);
    }

}
