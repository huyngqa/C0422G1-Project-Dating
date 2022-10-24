package com.codegym.dating.service.impl;

import com.codegym.dating.model.Account;
import com.codegym.dating.repository.IAccountRepository;
import com.codegym.dating.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public Optional<Account> findByEmail(String email) {
        return iAccountRepository.findByEmail(email);
    }

    @Override
    public void saveNewPassword(String password, String email) {
        iAccountRepository.saveNewPassword(password, email);
    }
}
