package com.codegym.dating.controller;

import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.*;
import com.codegym.dating.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/public/user")
public class UserRestController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IUserHobbitService iUserHobbitService;

    @Autowired
    private IUserTargetService iUserTargetService;

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private IHobbitService iHobbitService;

    @Autowired
    private ITargetService iTargetService;

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {

        User user = this.iUserService.findUserById(id);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get-all-hobbit")
    public ResponseEntity<List<Hobbit>> getAllHobbit() {
        return new ResponseEntity<>(this.iHobbitService.findAllHobbit(), HttpStatus.OK);
    }

    @GetMapping("/get-all-target")
    public ResponseEntity<List<Target>> getAllTarget() {
        return new ResponseEntity<>(this.iTargetService.findAllTarget(), HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<Map<String, String>> updateUser(@RequestBody @Valid UserDto userDto,
                                                          BindingResult bindingResult) {

        User user = this.iUserService.findUserById(userDto.getIdUser());

        new UserDto().validate(userDto, bindingResult);

        if (bindingResult.hasErrors()) {
            Map<String, String> errMap = new HashMap<>();

            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(errMap, HttpStatus.BAD_REQUEST);
        }

        BeanUtils.copyProperties(userDto, user);

        this.iUserService.updateUser(user);

        if (!userDto.getHobbits().isEmpty()) {
            for (Integer idHobbit : userDto.getHobbits()) {
                Hobbit hobbit = this.iHobbitService.findById(idHobbit);
                UserHobbit userHobbit = new UserHobbit();
                userHobbit.setHobbit(hobbit);
                userHobbit.setUser(user);
                this.iUserHobbitService.saveUserHobbit(userHobbit);
            }
        }

        if (!userDto.getTargets().isEmpty()) {
            for (Integer idTarget : userDto.getTargets()) {
                Target target = this.iTargetService.findById(idTarget);
                UserTarget userTarget = new UserTarget();
                userTarget.setTarget(target);
                userTarget.setUser(user);
                this.iUserTargetService.saveUserTarget(userTarget);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
