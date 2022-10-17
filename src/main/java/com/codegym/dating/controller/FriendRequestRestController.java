package com.codegym.dating.controller;

import com.codegym.dating.dto.FriendListDto;
import com.codegym.dating.model.FriendList;
import com.codegym.dating.service.IFriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("api/users")
public class FriendRequestRestController {
    @Autowired
    private IFriendListService friendListService;

    @GetMapping("request/{id}")
    public ResponseEntity<List<FriendListDto>> findAllRequest(@PathVariable int id){
        List<FriendListDto> friendListDto = this.friendListService.findAllRequest(id);
        if (friendListDto.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(friendListDto,HttpStatus.OK);

    }
    @PatchMapping ("accept/{id1}/{id2}")
    public ResponseEntity<Void> acceptRequest(@PathVariable int id1,
                                               @PathVariable int id2){
        friendListService.acceptRequest(id1,id2);
       return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("denied/{id1}/{id2}")
    public ResponseEntity<Void> deniedRequest(@PathVariable Integer id1,
                                              @PathVariable Integer id2){
        friendListService.deniedRequest(id1,id2);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
