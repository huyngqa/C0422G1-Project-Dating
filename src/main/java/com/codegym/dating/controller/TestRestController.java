package com.codegym.dating.controller;

import com.codegym.dating.model.Account;
import com.codegym.dating.model.User;
import com.codegym.dating.repository.IAccountRepository;
import com.codegym.dating.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class TestRestController {
    @Autowired
    private IAccountRepository iAccountRepository;

    @Autowired
    private IUserRepository iUserRepository;

    @GetMapping("/users/test")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Account>> listResponseEntity() {
        return new ResponseEntity<>(iAccountRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/admin/test")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> testUser() {
        return new ResponseEntity<>(iUserRepository.findAll(), HttpStatus.OK);
    }
}
