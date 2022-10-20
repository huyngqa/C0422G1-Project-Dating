package com.codegym.dating.controller;

import com.codegym.dating.dto.UserDto;

import com.codegym.dating.model.User;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api")
public class UserRestController {
@Autowired
private IUserService iUserService;
    @GetMapping("/users/users/{id}")
    public ResponseEntity<UserDto>findById(@PathVariable int id) {
        UserDto userDto = this.iUserService.findByIdDto(id).orElse(null);
        if (userDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private IUserService iUserService;


    @GetMapping("/users/listAndSearch")
    public ResponseEntity<Page<UserDto>> userPage(@RequestParam Optional<String> name,
                                                  @RequestParam Optional<String> dateOfBirth,
                                                  @RequestParam Optional<String> address,
                                                  @RequestParam Optional<String> job,
                                                  @RequestParam Optional<String> gender,
                                                  @RequestParam Optional<String> hobbitName,
                                                  @PageableDefault(size = 20) Pageable pageable) {
        String name1 = name.orElse("");
        String dateOfBirth1 = dateOfBirth.orElse("");
        String address1 = address.orElse("");
        String job1 = job.orElse("");
        String gender1 = gender.orElse("");
        String hobbit1 = hobbitName.orElse("");
        Page<UserDto> users = this.iUserService.userPage(name1,
                dateOfBirth1,
                address1,
                job1,
                gender1,
                hobbit1,
                pageable);
        if (!users.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @GetMapping("/public/searchPage")
    public ResponseEntity<Page<UserDto>> goSearch(@PageableDefault(4) Pageable pageable,
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
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }
}
