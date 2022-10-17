package com.codegym.dating.controller;


import com.codegym.dating.dto.UserDto;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/public")
@CrossOrigin("http://localhost:4200")
public class UserRestController {
    @Autowired
    private IUserService userService;

    @GetMapping("/pageSearch")
    public ResponseEntity<Page<UserDto>> goPage(@PageableDefault(5) Pageable pageable,
                                                Optional<String> name) {
        String keyword = name.orElse("");
        Page<UserDto> userDtoPage = userService.findAllSearchPage(pageable, keyword);
        if (keyword.length() > 30 || keyword.matches("^\\W+$")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!userDtoPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(userDtoPage, HttpStatus.OK);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Page<UserDto>> goPage(@PageableDefault(5) Pageable pageable
    ) {

        Page<UserDto> userDtoPage = userService.findAllPage(pageable);
        if (!userDtoPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(userDtoPage, HttpStatus.OK);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserDto>> goSearch(Optional<String> name) {
        String keyword = name.orElse("");
        List<UserDto> userDtoList = userService.findAllSearch(keyword);
        if (keyword.length() > 30 || keyword.matches("^\\W+$")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (userDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(userDtoList, HttpStatus.OK);
        }
    }
}