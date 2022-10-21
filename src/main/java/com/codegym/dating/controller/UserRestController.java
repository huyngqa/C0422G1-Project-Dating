package com.codegym.dating.controller;

import com.codegym.dating.dto.UserClassDto;
import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.*;
import com.codegym.dating.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class UserRestController {
    @Autowired
    private IUserService iUserService;


    @Autowired
    private IUserHobbitService iUserHobbitService;

    @Autowired
    private IUserTargetService iUserTargetService;

    @Autowired
    private IHobbitService iHobbitService;

    @Autowired
    private ITargetService iTargetService;


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
        Page<UserDto> userDtoPage = iUserService.findAllSearchPage(pageable, keyword);
        if (keyword.length() > 30 || keyword.matches("^\\W+$")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!userDtoPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(userDtoPage, HttpStatus.OK);
        }
    }

    @GetMapping("/users/users/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable int id) {
        UserDto userDto = this.iUserService.findByIdDto(id).orElse(null);
        if (userDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PatchMapping("/users/update_active/{id}")
    public ResponseEntity<User> updateStatus(@PathVariable Integer id,
                                             @RequestBody UserClassDto userDto, BindingResult bindingResult) {

        userDto.setIdUser(id);

        new UserClassDto().validate(userDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        User user = new User();

        BeanUtils.copyProperties(userDto, user);

        this.iUserService.updateStatusActive(user);

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PatchMapping("/users/update_avatar/{id}")
    public ResponseEntity<User> updateAvatar(@PathVariable Integer id,
                                             @RequestBody @Valid UserClassDto userDto, BindingResult bindingResult) {

        userDto.setIdUser(id);

        new UserClassDto().validate(userDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        User user = new User();

        BeanUtils.copyProperties(userDto, user);

        this.iUserService.updateAvatar(user);


        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/public/user/get-all-hobbit")
    public ResponseEntity<List<Hobbit>> getAllHobbit() {
        return new ResponseEntity<>(this.iHobbitService.findAllHobbit(), HttpStatus.OK);
    }

    @GetMapping("/public/user/get-all-target")
    public ResponseEntity<List<Target>> getAllTarget() {
        return new ResponseEntity<>(this.iTargetService.findAllTarget(), HttpStatus.OK);
    }

    @PatchMapping("/public/user/update")
    public ResponseEntity<Map<String, String>> updateUser(@RequestBody @Valid UserClassDto userDto,
                                                          BindingResult bindingResult) {

        User user = this.iUserService.findById(userDto.getIdUser());

        new UserClassDto().validate(userDto, bindingResult);

        if (bindingResult.hasErrors()) {
            Map<String, String> errMap = new HashMap<>();

            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(errMap, HttpStatus.BAD_REQUEST);
        }

        BeanUtils.copyProperties(userDto, user);

        this.iUserService.updateUser(user);

        if (userDto.getHobbits() != null) {
            for (Integer idHobbit : userDto.getHobbits()) {
                Hobbit hobbit = this.iHobbitService.findById(idHobbit);
                UserHobbit userHobbit = new UserHobbit();
                userHobbit.setHobbit(hobbit);
                userHobbit.setUser(user);
                this.iUserHobbitService.saveUserHobbit(userHobbit);
            }
        }

        if (userDto.getTargets() != null) {
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
