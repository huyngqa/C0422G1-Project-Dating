package com.codegym.dating.service.impl;

import com.codegym.dating.model.Account;
import com.codegym.dating.repository.IAccountRepository;
import com.codegym.dating.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public Account findAccountByEmail(String email) {
        return iAccountRepository.findByEmail(email);
    }
}
