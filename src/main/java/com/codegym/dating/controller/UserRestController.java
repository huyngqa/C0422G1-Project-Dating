package com.codegym.dating.controller;


import com.codegym.dating.dto.UserDto;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("userPage")
public class UserRestController {
    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public ResponseEntity<Page<UserDto>> goPage(@PageableDefault(5) Pageable pageable,
                                                Optional<String> name) {
        String keyword = name.orElse("");
        Page<UserDto> userDtoPage = userService.findAllSearchPage(pageable, keyword);
        if (!userDtoPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(userDtoPage, HttpStatus.OK);
        }
    }
}
