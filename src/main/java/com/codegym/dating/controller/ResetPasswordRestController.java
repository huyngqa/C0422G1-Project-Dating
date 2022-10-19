package com.codegym.dating.controller;

import com.codegym.dating.model.Account;
import com.codegym.dating.model.JwtRequest;
import com.codegym.dating.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/users/account")
public class ResetPasswordRestController {

    @Autowired
    private IAccountService iAccountService;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PatchMapping("/checkPassword/{password}/{newPassword}")
    public ResponseEntity<?> checkPassword(@PathVariable String password,
                                           @PathVariable String newPassword) {

        Account account = this.iAccountService.findByPassword(password);

        if (account != null) {
            account.setPassword(passwordEncoder().encode(newPassword));
            iAccountService.updatePassword(account);
            return new ResponseEntity<>(account, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/changePassword/{idAccount}")
    public ResponseEntity<?> doResetPassword(@RequestBody JwtRequest authenticationRequest,
                                             @PathVariable Integer idAccount) {
        Optional<Account> account = iAccountService.findById(idAccount);

        if (account.isPresent()) {
            if (BCrypt.checkpw(authenticationRequest.getPassword(), account.get().getPassword())) {
                if (!Objects.equals(authenticationRequest.getNewPassword(), "")) {
                    iAccountService.saveNewPassword(passwordEncoder().encode(authenticationRequest.getNewPassword()), idAccount);
                    return new ResponseEntity<>(HttpStatus.OK);
                }
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
