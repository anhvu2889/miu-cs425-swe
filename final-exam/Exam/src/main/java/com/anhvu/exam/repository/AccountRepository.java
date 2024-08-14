package com.anhvu.exam.repository;

import com.anhvu.exam.model.Account;
import com.anhvu.exam.model.ActiveStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByDateOpenedBeforeAndStatusOrderByBalanceDesc(LocalDate dateOpened, ActiveStatus status);
    
    List<Account> findByCustomersCustomerId(Integer customerId);
}
