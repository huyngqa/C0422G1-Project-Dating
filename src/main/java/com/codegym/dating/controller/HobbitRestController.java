package com.codegym.dating.controller;

import com.codegym.dating.dto.HobbitDto;
import com.codegym.dating.dto.UserDto;
import com.codegym.dating.service.IUserHobbitService;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("hobbits")
public class HobbitRestController {
    @Autowired
    private IUserHobbitService iUserHobbitService;
    @GetMapping("{id}")
    public ResponseEntity<List<HobbitDto>> findByIdDto(@PathVariable int id) {
        List<HobbitDto> hobbitDtoList = this.iUserHobbitService.findAllByIdUser(id);
        if (hobbitDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hobbitDtoList,HttpStatus.OK);
    }
}
