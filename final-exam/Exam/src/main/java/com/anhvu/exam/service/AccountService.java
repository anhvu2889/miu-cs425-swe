package com.anhvu.exam.service;

import com.anhvu.exam.dto.AccountRequest;
import com.anhvu.exam.exception.AccountNotFoundException;
import com.anhvu.exam.exception.CustomerNotFoundException;
import com.anhvu.exam.model.Account;
import com.anhvu.exam.model.Customer;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();

    Account getAccountById(Long id) throws AccountNotFoundException;

    List<Account> getAccountsByCustomerId(Integer customerId);

    List<Account> getPlatinumAccounts();

    Account createAccountForCustomer(Integer customerId, AccountRequest accountRequest) throws CustomerNotFoundException;

    List<Customer> getCustomersByAccountId(Long accountId);

    Account updateAccount(Long id, AccountRequest accountRequest) throws AccountNotFoundException;

    void deleteAccount(Long id) throws AccountNotFoundException;
}
