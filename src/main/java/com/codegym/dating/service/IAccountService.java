package com.codegym.dating.service;

import com.codegym.dating.model.Account;

public interface IAccountService {
    Account findAccountByEmail(String email);
}
