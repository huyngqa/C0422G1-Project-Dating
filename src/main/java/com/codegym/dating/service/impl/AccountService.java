package com.codegym.dating.service.impl;

import com.codegym.dating.model.Account;
import com.codegym.dating.repository.IAccountRepository;
import com.codegym.dating.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository iAccountRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public Account findAccountByEmail(String email) {
        return iAccountRepository.findByEmail(email);
    }

    @Override
    public List<Account> findAllAccount() {
        return this.iAccountRepository.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer id) {
        return this.iAccountRepository.findAccountById(id);
    }

    @Override
    public Account saveAccount(Account account) {

        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));

        account.setStatus(0);

        return this.iAccountRepository.save(account);
    }

    @Override
    public void updateAccount(Account account) {
        this.iAccountRepository.updateAccount(account);
    }
}
