package com.codegym.dating.controller;


import com.codegym.dating.dto.UserDto;
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
@RequestMapping("/api/public")
@CrossOrigin("http://localhost:4200")
public class UserRestController {
    @Autowired
    private IUserService userService;
    @GetMapping("/searchPage")
    public ResponseEntity<Page<UserDto>> goSearch(@PageableDefault(3) Pageable pageable,
                                                @RequestParam Optional<String> name) {
        String keyword = name.orElse("");
        System.out.println(keyword);
        Page<UserDto> userDtoPage = userService.findAllSearchPage(pageable,keyword);
        if (keyword.length() > 30 || keyword.matches("^\\W+$")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!userDtoPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(userDtoPage, HttpStatus.OK);
        }
    }
}