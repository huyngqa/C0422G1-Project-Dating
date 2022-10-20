package com.codegym.dating.controller;

import com.codegym.dating.dto.UserDto;

import com.codegym.dating.model.User;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
@CrossOrigin
=======

import java.util.Optional;

>>>>>>> origin/TrangNTT-SearchByName
@RestController
@RequestMapping("api")
public class UserRestController {
<<<<<<< HEAD
@Autowired
private IUserService iUserService;
    @GetMapping("/users/users/{id}")
    public ResponseEntity<UserDto>findById(@PathVariable int id) {
        UserDto userDto = this.iUserService.findByIdDto(id).orElse(null);
        if (userDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
=======
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
>>>>>>> origin/TrangNTT-SearchByName
        }
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }
}
