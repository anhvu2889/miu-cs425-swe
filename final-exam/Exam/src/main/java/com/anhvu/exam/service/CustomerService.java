package com.anhvu.exam.service;

import com.anhvu.exam.exception.CustomerNotFoundException;
import com.anhvu.exam.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(Integer id) throws CustomerNotFoundException;

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Integer id, Customer customer) throws CustomerNotFoundException;

    void deleteCustomer(Integer id) throws CustomerNotFoundException;
}
