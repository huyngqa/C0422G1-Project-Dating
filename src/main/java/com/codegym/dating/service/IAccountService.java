package com.codegym.dating.service;

import com.codegym.dating.common.AuthenticationProvider;
import com.codegym.dating.model.Account;

public interface IAccountService {
//    void saveAccount(Account account);

    Account getAccountByEmail(String email);

    void createAccountForFacebook(String email, AuthenticationProvider authenticationProvider);

    void updateAccountIfExists(Account account, AuthenticationProvider authenticationProvider);
}
