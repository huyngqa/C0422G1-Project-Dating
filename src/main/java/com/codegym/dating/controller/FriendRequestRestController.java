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
@RequestMapping("user")
public class FriendRequestRestController {
    @Autowired
    private IFriendListService friendListService;

    @GetMapping("/request")
    public ResponseEntity<List<FriendListDto>> findAllRequest(@RequestParam int id){
        List<FriendListDto> friendListDto = this.friendListService.findAllRequest(id);
        if (friendListDto.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(friendListDto,HttpStatus.OK);

    }
    @PostMapping("/accept")
    public ResponseEntity<Void> accreptRequest(){
        friendListService.acceptRequest();
       return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/denied")
    public ResponseEntity<Void> deniedRequest(){
        friendListService.deniedRequest();
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
