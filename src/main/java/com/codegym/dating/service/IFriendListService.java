package com.codegym.dating.service;

import com.codegym.dating.projection_dto.IUserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IFriendListService {
    Page<IUserDto> findAllFriendList(Integer id, String name, Pageable pageable);

//    void blockFriend(Integer[] idUser);

//    void deleteFriend(Integer[] idUser2);

    void deleteFriend(Integer idUser, Integer[] friendList);
//    void deleteFriend(int idUser1, int idUser2);

    void blockFriend(Integer idUser, Integer[] friendList);
//    Page<IUserDto> findAllListFriend(Integer idUser,String name, Pageable pageable);

}
