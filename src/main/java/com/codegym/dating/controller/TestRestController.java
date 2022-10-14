package com.codegym.dating.controller;

import com.codegym.dating.dto.PostDto;
import com.codegym.dating.model.Account;
import com.codegym.dating.model.AccountRole;
import com.codegym.dating.model.composite.AccountRoleKey;
import com.codegym.dating.repository.IAccountRepository;
import com.codegym.dating.repository.IAccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class TestRestController {
    @Autowired
    private IAccountRoleRepository iAccountRoleRepository;
    @Autowired
    private IAccountRepository iAccountRepository;

    @GetMapping("/test")
    public ResponseEntity<String> listResponseEntity() {
        Optional<Account> account = iAccountRepository.findById(1);
        Optional<AccountRole> accountRole = iAccountRoleRepository.findById(new AccountRoleKey(1, 1));
        return new ResponseEntity<>(accountRole.get().getAccount().getEmail() + accountRole.get().getRole().getRoleName(), HttpStatus.OK);
    }

}
