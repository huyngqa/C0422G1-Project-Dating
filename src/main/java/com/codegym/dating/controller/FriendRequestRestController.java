package com.codegym.dating.controller;

import com.codegym.dating.service.impl.FriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("friendList")
@RestController
public class FriendRequestRestController {
    @Autowired
    private FriendListService friendListService;

    @GetMapping("{idUser1}/{idUser2}")
    public ResponseEntity<Boolean>checkRelationship(@PathVariable int idUser1,@PathVariable int idUser2){
        boolean result = this.friendListService.checkRelationship(idUser1,idUser2);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("add/{idUser1}/{idUser2}")
    public ResponseEntity<Void>addRequest(@PathVariable int idUser1,@PathVariable int idUser2){
          this.friendListService.addRequest(idUser1,idUser2);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
