package com.codegym.dating.service;

import com.codegym.dating.projection_dto.IUserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

    Page<IUserDto> findAllFriendList(Integer id, String name, Pageable pageable);

    void deleteFriend(Integer idUser, Integer[] friendList);

    void blockFriend(Integer idUser, Integer[] friendList);

}
