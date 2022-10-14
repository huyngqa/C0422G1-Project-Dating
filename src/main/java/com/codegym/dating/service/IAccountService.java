package com.codegym.dating.service;

import com.codegym.dating.model.Account;

public interface IAccountService {
    Account findByPassword (String password);

    public void updatePassword(Account account);
}
