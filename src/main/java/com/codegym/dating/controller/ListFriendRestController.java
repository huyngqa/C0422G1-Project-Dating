package com.codegym.dating.controller;

import com.codegym.dating.model.FriendList;
import com.codegym.dating.projection_dto.IUserDto;
import com.codegym.dating.service.IFriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/list")
public class ListFriendRestController {
    @Autowired
    private IFriendListService iFriendListService;
    @GetMapping("/friend_list")
    public ResponseEntity<Page<IUserDto>> showFriendList(@PageableDefault(size = 2) Pageable pageable, Optional<String> name){
        String keyWord = name.orElse("");
//        Page<FriendList> friendLists=iFriendListService.findAllFriendList(keyWord, pageable);
        Page<IUserDto> friendLists=iFriendListService.findAllFriendList(keyWord,pageable);
        if (friendLists.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(friendLists,HttpStatus.OK);
    }
}
