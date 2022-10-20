package com.codegym.dating.service.impl;

import com.codegym.dating.common.AuthenticationProvider;
import com.codegym.dating.model.Account;
import com.codegym.dating.repository.IAccountRepository;
import com.codegym.dating.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public Account getAccountByEmail(String email) {
        return iAccountRepository.findByEmail(email);
    }

    @Override
    public void createAccountForFacebook(String email, AuthenticationProvider authenticationProvider) {
        Account account = new Account();
        account.setEmail(email);
        account.setAuthProvider(authenticationProvider);
        iAccountRepository.save(account);
    }

    @Override
    public void updateAccountIfExists(Account account, AuthenticationProvider authenticationProvider) {
        account.setAuthProvider(authenticationProvider);
        iAccountRepository.save(account);
    }

}
