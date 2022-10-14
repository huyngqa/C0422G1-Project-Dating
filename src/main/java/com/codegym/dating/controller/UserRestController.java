package com.codegym.dating.controller;

import com.codegym.dating.dto.UserDto;

import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("users")
public class UserRestController {
@Autowired
private IUserService iUserService;
    @GetMapping("{id}")
    public ResponseEntity<UserDto>findById(@PathVariable int id) {
        UserDto userDto = this.iUserService.findByIdDto(id).orElse(null);
        if (userDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }
}
