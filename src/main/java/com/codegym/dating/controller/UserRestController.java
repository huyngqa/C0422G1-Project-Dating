package com.codegym.dating.controller;

import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.Account;
import com.codegym.dating.model.User;
import com.codegym.dating.model.UserHobbit;
import com.codegym.dating.model.UserTarget;
import com.codegym.dating.service.IAccountService;
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

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {

        User user = this.iUserService.findUserById(id);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save/{idAccount}")
    public ResponseEntity<Map<String, String>> saveUser(@PathVariable int idAccount,
                                                        @RequestBody @Valid UserDto userDto,
                                                        BindingResult bindingResult) {

        Account account = this.iAccountService.findAccountById(idAccount);

        if (account != null){
            if (account.getStatus() == 0){

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

                User newUser = this.iUserService.saveUser(user);

                for (UserHobbit userHobbit : userDto.getUserHobbits()) {
                    userHobbit.getId().setIdUser(newUser.getIdUser());
                    this.iUserHobbitService.saveUserHobbit(userHobbit);
                }

                for (UserTarget userTarget : userDto.getUserTargets()) {
                    userTarget.getId().setIdUser(newUser.getIdUser());
                    this.iUserTargetService.saveUserTarget(userTarget);
                }

                account.setUser(newUser);

                this.iAccountService.updateAccount(account);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
