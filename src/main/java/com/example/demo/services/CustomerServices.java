package com.example.demo.services;


import com.example.demo.dto.AddCustomer;
import com.example.demo.entities.Address;
import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServices {
    private final CustomerRepository customerRepository;
    private final AddressService addressService;

    @Autowired
    public CustomerServices(CustomerRepository customerRepository, AddressService addressService) {
        this.customerRepository = customerRepository;
        this.addressService = addressService;
    }




    public List<Customer> getAll()
    {
        return customerRepository.findAll();
    }

    public Customer getById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("CUSTOMER_NOT_FOUND"));
    }

@Transactional
    public Customer addCustomer (AddCustomer addCustomer, Long id) {
        Customer customer = new Customer();
        if (id != null){
            customer = getById(id);

        }


        customer.setFirstName(addCustomer.getFirstName());
        customer.setLastName(addCustomer.getLastName());
        if (id == null) {
            customer = getById(id);
        }

        Address address = addressService.getAddress(addCustomer.getAddress());
        customer.setAddress(address);

        return customerRepository.save(customer);



    }

    @Transactional
    public boolean deleteCustomer(Long id) {
        Customer customer = getById(id);
        customerRepository.delete(customer);
        return true;
    }
}

