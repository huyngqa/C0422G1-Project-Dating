package com.codegym.dating.service;

import com.codegym.dating.model.Account;

import java.util.Optional;

public interface IAccountService {
//    Account findByPassword (String password);

    Optional<Account> findById(Integer idAccount);

//    void updatePassword(Account account);

    void saveNewPassword(String password, Integer idAccount);
}
