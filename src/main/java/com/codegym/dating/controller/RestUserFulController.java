package com.codegym.dating.controller;

import com.codegym.dating.DTO.ListUserDto;
import com.codegym.dating.model.User;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "api/admin")
public class RestUserFulController {

    @Autowired
    private IUserService iUserService;

    @GetMapping(value = "/list/user")
    public ResponseEntity<Page<ListUserDto>> findAll(@PageableDefault(page =0,size = 5)Pageable pageable,
                                                     @RequestParam Optional<String> name){
        String nameVal = name.orElse("");
        Page<ListUserDto> userPage = iUserService.findAll(pageable);
        if(userPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(userPage, HttpStatus.OK);
        }
    }
}
