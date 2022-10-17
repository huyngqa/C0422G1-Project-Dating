package com.codegym.dating.controller;

import com.codegym.dating.service.IFriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users/friendList")
public class FriendRequestRestController {
    @Autowired
    private IFriendListService iFriendListService;
    @GetMapping("check/{idUser1}/{idUser2}")
    public ResponseEntity<Boolean>checkFriend(@PathVariable int idUser1, @PathVariable int idUser2){
        boolean isFriend = this.iFriendListService.checkFriend(idUser1,idUser2);
        return new ResponseEntity<>(isFriend, HttpStatus.OK);
    }

    @PostMapping("addRequest/{idUser1}/{idUser2}")
    public ResponseEntity<Void>addRequest(@PathVariable int idUser1, @PathVariable int idUser2){
        this.iFriendListService.addRequest(idUser1,idUser2);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
