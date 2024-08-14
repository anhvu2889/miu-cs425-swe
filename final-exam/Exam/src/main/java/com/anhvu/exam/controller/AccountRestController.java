package com.anhvu.exam.controller;

import com.anhvu.exam.dto.AccountRequest;
import com.anhvu.exam.exception.AccountNotFoundException;
import com.anhvu.exam.exception.CustomerNotFoundException;
import com.anhvu.exam.model.Account;
import com.anhvu.exam.model.Customer;
import com.anhvu.exam.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/accounts",produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountRestController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{accountId}")
    public Account getAccountById(@PathVariable Long accountId) throws AccountNotFoundException {
        return accountService.getAccountById(accountId);
    }

    @GetMapping("/platinum")
    public List<Account> getPlatinumAccounts() {
        return accountService.getPlatinumAccounts();
    }

    @GetMapping("/customer/{customerId}")
    public List<Account> getAccountsByCustomerId(@PathVariable Integer customerId) {
        return accountService.getAccountsByCustomerId(customerId);
    }

    @PostMapping("/customer/{customerId}")
    public ResponseEntity<Account> createAccount(@PathVariable Integer customerId, @RequestBody AccountRequest accountRequest) throws CustomerNotFoundException {
        Account account = accountService.createAccountForCustomer(customerId, accountRequest);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long accountId, @RequestBody AccountRequest accountRequest) {
        Account updatedAccount = accountService.updateAccount(accountId, accountRequest);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long accountId) throws AccountNotFoundException {
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/customers/{accountId}")
    public List<Customer> getCustomersByAccountId(@PathVariable Long accountId) {
        return accountService.getCustomersByAccountId(accountId);
    }
}
