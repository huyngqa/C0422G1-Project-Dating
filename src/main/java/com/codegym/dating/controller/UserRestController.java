package com.codegym.dating.controller;

import com.codegym.dating.model.User;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {

        User user = this.iUserService.findUserById(id);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
