package com.anhvu.exam.repository;

import com.anhvu.exam.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Method to find Customers by Account ID
    List<Customer> findByAccountsAccountId(Long accountId);
}
