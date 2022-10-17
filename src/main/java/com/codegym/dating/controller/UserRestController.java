package com.codegym.dating.controller;

import com.codegym.dating.model.User;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private IUserService iUserService ;

    @GetMapping("")
    public ResponseEntity<Page<User>> userPage(@RequestParam Optional<String> nameUser,
                                               Optional<String>dateOfBirth,
                                               Optional<String>address,
                                               Optional<String>job,
                                               Optional<String>gender,
                                               Optional<String>hobbit,
                                               @PageableDefault(size = 20) Pageable pageable){
        String nameUser1 = nameUser.orElse("");
        String dateOfBirth1 = dateOfBirth.orElse("1970");
        String address1 = address.orElse("");
        String job1 = job.orElse("");
        String gender1 = gender.orElse("");
        String hobbit1 = hobbit.orElse("");
        Page<User>users = this.iUserService.userPage(
                 nameUser1,
                dateOfBirth1,
                address1,
                job1,
                gender1,
                hobbit1,
                pageable);
        if (!users.hasContent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

}
