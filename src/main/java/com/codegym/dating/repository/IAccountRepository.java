package com.codegym.dating.repository;

import com.codegym.dating.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    Account findByEmail(String email);
}
