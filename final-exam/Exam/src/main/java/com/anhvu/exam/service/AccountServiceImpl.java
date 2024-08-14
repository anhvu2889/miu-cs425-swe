package com.anhvu.exam.service;

import com.anhvu.exam.dto.AccountRequest;
import com.anhvu.exam.model.Account;
import com.anhvu.exam.model.ActiveStatus;
import com.anhvu.exam.model.Customer;
import com.anhvu.exam.repository.AccountRepository;
import com.anhvu.exam.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final int PLATINUM_REQUIRED_YEAR = 5;
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public List<Account> getPlatinumAccounts() {
        LocalDate fiveYearsAgo = LocalDate.now().minusYears(PLATINUM_REQUIRED_YEAR);
        return accountRepository.findByDateOpenedBeforeAndStatusOrderByBalanceDesc(fiveYearsAgo, ActiveStatus.ACTIVE);
    }

    public List<Account> getAccountsByCustomerId(Integer customerId) {
        return accountRepository.findByCustomersCustomerId(customerId);
    }

    @Transactional
    public Account createAccountForCustomer(Integer customerId, AccountRequest accountRequest) {
        // Find the customer
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Create the new account
        Account account = new Account();
        account.setAccountNumber(accountRequest.getAccountNumber());
        account.setDateOpened(accountRequest.getDateOpened());
        account.setStatus(accountRequest.getStatus());
        account.setBalance(accountRequest.getBalance());

        // Save the account
        Account savedAccount = accountRepository.save(account);

        // Associate the account with the customer
        customer.getAccounts().add(savedAccount);
        customerRepository.save(customer);

        return savedAccount;
    }

    public Account updateAccount(Long id, AccountRequest accountDto) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setAccountNumber(accountDto.getAccountNumber());
        account.setDateOpened(accountDto.getDateOpened());
        account.setStatus(accountDto.getStatus());
        account.setBalance(accountDto.getBalance());

        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        accountRepository.delete(account);
    }

    public List<Customer> getCustomersByAccountId(Long accountId) {
        return customerRepository.findByAccountsAccountId(accountId);
    }
}
