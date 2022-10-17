package com.codegym.dating.service.impl;

import com.codegym.dating.common.AuthenticationProvider;
import com.codegym.dating.model.Account;
import com.codegym.dating.repository.IAccountRepository;
import com.codegym.dating.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
=======
import org.springframework.security.crypto.password.PasswordEncoder;
>>>>>>> 2d8336d32df7fbf877696623258be8b311522464
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Override
//    public void saveAccount(Account account) {
//        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
//        iAccountRepository.save(account);
//    }

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
