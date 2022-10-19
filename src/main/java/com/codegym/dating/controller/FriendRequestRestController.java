package com.codegym.dating.controller;

import com.codegym.dating.service.IFriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("api/users/friendList")
public class FriendRequestRestController {
    @Autowired
    private IFriendListService iFriendListService;

    @GetMapping("check/{idUser1}/{idUser2}")
    public ResponseEntity<String>checkFriend(@PathVariable int idUser1, @PathVariable int idUser2){
        String relationship = this.iFriendListService.checkFriend(idUser1,idUser2);
        return new ResponseEntity<>(relationship, HttpStatus.OK);
    }

    @PostMapping("addRequest/{idUser1}/{idUser2}")
    public ResponseEntity<Void>addRequest(@PathVariable int idUser1, @PathVariable int idUser2){
        String isFriend = this.iFriendListService.checkFriend(idUser1,idUser2);
        if (isFriend == "Chưa có quan hệ"){
            this.iFriendListService.addRequest(idUser1,idUser2);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }


    @DeleteMapping("removeRequest/{idUser1}/{idUser2}")
    public ResponseEntity<Void>removeRequest(@PathVariable int idUser1, @PathVariable int idUser2){
        String isFriend = this.iFriendListService.checkFriend(idUser1,idUser2);
        if (isFriend == "Đã gửi lời mời kết bạn"){
            this.iFriendListService.removeRequest(idUser1,idUser2);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
