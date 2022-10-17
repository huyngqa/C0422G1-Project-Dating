package com.codegym.dating.service.impl;

import com.codegym.dating.dto.FriendListDto;
import com.codegym.dating.dto.UserDto;
import com.codegym.dating.repository.IFriendListRepository;
import com.codegym.dating.service.IFriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendListService implements IFriendListService {
    @Autowired
    private IFriendListRepository iFriendListRepository;
    @Override
    public boolean checkFriend(Integer idUser1, Integer idUser2) {
        FriendListDto friendListDto = this.iFriendListRepository.checkFriend(idUser1,idUser2);
       if (friendListDto == null) {
           return false;
       }
       return true;
    }

    @Override
    public void addRequest(Integer idUser1, Integer idUser2) {
        this.iFriendListRepository.addRequest(idUser1,idUser2);
    }
}
