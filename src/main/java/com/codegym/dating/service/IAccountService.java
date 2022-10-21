package com.codegym.dating.service;

import com.codegym.dating.model.Account;

import java.util.Optional;

public interface IAccountService {

    Optional<Account> findById(Integer idAccount);

    void saveNewPassword(String password, Integer idAccount);
}
