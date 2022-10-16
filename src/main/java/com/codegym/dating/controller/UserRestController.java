package com.codegym.dating.controller;

import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.User;
import com.codegym.dating.model.UserHobbit;
import com.codegym.dating.model.UserTarget;
import com.codegym.dating.service.IUserHobbitService;
import com.codegym.dating.service.IUserService;
import com.codegym.dating.service.IUserTargetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IUserHobbitService iUserHobbitService;

    @Autowired
    private IUserTargetService iUserTargetService;

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {

        User user = this.iUserService.findUserById(id);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> saveUser(@RequestBody @Valid UserDto userDto,
                                                      BindingResult bindingResult) {

        // validate
        new UserDto().validate(userDto, bindingResult);

        if (bindingResult.hasErrors()){
            Map<String, String> errMap = new HashMap<>();

            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(errMap, HttpStatus.BAD_REQUEST);
        }

        // save user
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        this.iUserService.saveUser(user);

        // save hobbit and target
        User newUser = this.iUserService.findAllUser().get(this.iUserService.findAllUser().size() - 1);

        for (UserHobbit userHobbit : userDto.getUserHobbits()) {
            userHobbit.getId().setIdUser(newUser.getIdUser());
            this.iUserHobbitService.saveUserHobbit(userHobbit);
        }

        for (UserTarget userTarget : userDto.getUserTargets()) {
            userTarget.getId().setIdUser(newUser.getIdUser());
            this.iUserTargetService.saveUserTarget(userTarget);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
