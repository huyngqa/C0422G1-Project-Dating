package com.codegym.dating.controller;

import com.codegym.dating.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class TestRestController {
    @Autowired
    private IAccountRepository iAccountRepository;
    @GetMapping("/test")
    public ResponseEntity<String> listResponseEntity() {
        return new ResponseEntity<>(iAccountRepository.findById(7).get().getEmail(), HttpStatus.OK);
    }


}
