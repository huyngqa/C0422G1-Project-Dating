package com.codegym.dating.service.impl;

import com.codegym.dating.projection_dto.IUserDto;
import com.codegym.dating.repository.IFriendListRepository;
import com.codegym.dating.service.IFriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendListService implements IFriendListService {
    @Autowired
    private IFriendListRepository iFriendListRepository;
//    @Override
//    public Page<FriendList> findAllFriendList(String name, Pageable pageable) {
//        return iFriendListRepository.findAllListFriend("%"+name+"%", pageable);
//    }

    @Override
    public Page<IUserDto> findAllFriendList(String name, Pageable pageable) {
        return iFriendListRepository.findAllListFriend("%" + name + "%",pageable);
    }
}
