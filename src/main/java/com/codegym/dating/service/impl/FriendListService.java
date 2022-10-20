package com.codegym.dating.service.impl;

import com.codegym.dating.projection_dto.IUserDto;
import com.codegym.dating.repository.IFriendListRepository;
import com.codegym.dating.service.IFriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FriendListService implements IFriendListService {
    @Autowired
    private IFriendListRepository iFriendListRepository;

    @Override
    public Page<IUserDto> findAllFriendList(Integer id, String name, Pageable pageable) {
        return iFriendListRepository.findAllListFriend(id,"%" + name + "%", pageable);
    }

//    @Override
//    public void blockFriend(Integer[] idUser) {
//        for (int i = 0; i < idUser.length; i++) {
//            iFriendListRepository.blockFriend(idUser[i], idUser[i + 1]);
//        }
//    }

    @Override
    public void deleteFriend(Integer idUser, Integer[] friendList) {
        for (int i = 0; i < friendList.length; i++) {
            this.iFriendListRepository.deleteFriend(idUser, friendList[i]);
        }
    }

    @Override
    public void blockFriend(Integer idUser, Integer[] friendList) {
        for (int i = 0; i < friendList.length ; i++) {
            this.iFriendListRepository.blockFriend(idUser,friendList[i]);
        }
    }

//    @Override
//    public Page<IUserDto> findAllListFriend(Integer idUser, String name, Pageable pageable) {
//        return this.iFriendListRepository.findAllListFriend(idUser,name,pageable);
//    }

//    @Override
//    public void deleteFriend(int idUser1, int idUser2) {
//        this.iFriendListRepository.deleteFriend(idUser1,idUser2);
//    }

//    @Override
//    public void deleteFriend(Integer[] idUser2) {
//        for (int i = 0; i < idUser2.length; i++) {
//            iFriendListRepository.deleteFriend(idUser2[i], idUser2[i + 1]);
//        }
//    }
}
