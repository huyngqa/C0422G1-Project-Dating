package com.codegym.dating.controller;

import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.User;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private IUserService iUserService;

    @PatchMapping("/update_active/{id}")
    public ResponseEntity<User> updateStatus(@PathVariable Integer id, RedirectAttributes redirectAttributes ,
                                             @RequestBody UserDto userDto, BindingResult bindingResult) {

        new UserDto().validate(userDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        User user = new User();

        BeanUtils.copyProperties(userDto, user);

        this.iUserService.updateStatusActive(user);

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PatchMapping("/update_avatar/{id}")
    public ResponseEntity<User> updateAvatar(@PathVariable Integer id,RedirectAttributes redirectAttributes,
                                             @RequestBody @Valid UserDto userDto, BindingResult bindingResult) {

        new UserDto().validate(userDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        User user = new User();

        BeanUtils.copyProperties(userDto, user);

        this.iUserService.updateAvatar(user);

        redirectAttributes.addFlashAttribute("msg","cập nhật thành công");

        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
