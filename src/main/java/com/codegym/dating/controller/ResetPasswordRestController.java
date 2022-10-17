package com.codegym.dating.controller;

import com.codegym.dating.model.Account;
import com.codegym.dating.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/rest")
public class ResetPasswordRestController {

    @Autowired
    private IAccountService iAccountService;

    @PatchMapping("/checkPassword/{password}/{newPassword}")
    public ResponseEntity<?> checkPassword(@PathVariable String password,
                                           @PathVariable String newPassword) {

        Account account = this.iAccountService.findByPassword(password);

        if (account != null) {
            account.setPassword(newPassword);
            iAccountService.updatePassword(account);
            return new ResponseEntity<>(account, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
