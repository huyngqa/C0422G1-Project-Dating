package com.codegym.dating.service.impl;

import com.codegym.dating.dto.FriendListDto;
import com.codegym.dating.repository.IFriendListRepository;
import com.codegym.dating.service.IFriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendListService implements IFriendListService {
    @Autowired
    private IFriendListRepository friendListRepository;

    @Override
    public List<FriendListDto> findAllRequest(int id) {
        return friendListRepository.findAllRequestFriend(id);
    }

    @Override
    public void acceptRequest(Integer idUser1 , Integer idUser2) {
        friendListRepository.acceptRequest(idUser1,idUser2);
    }

    @Override
    public void deniedRequest(Integer idUser1 , Integer idUser2) {
        friendListRepository.deniedRequest(idUser1,idUser2);
    }
}
