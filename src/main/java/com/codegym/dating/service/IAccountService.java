package com.codegym.dating.service;

import com.codegym.dating.model.Account;

import java.util.List;

public interface IAccountService {
    Account findAccountByEmail(String email);

    List<Account> findAllAccount();

    Account findAccountById(Integer id);

    Account saveAccount(Account account);

    void updateAccount(Account account);
}
