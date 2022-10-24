package com.codegym.dating.service;

import com.codegym.dating.model.Account;

import java.util.Optional;

public interface IAccountService {

    Optional<Account> findByEmail(String email);

    void saveNewPassword(String password, String email);
}
