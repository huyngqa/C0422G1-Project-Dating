package com.codegym.dating.service;

import com.codegym.dating.model.FriendList;
import com.codegym.dating.projection_dto.IUserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFriendListService {
//    Page<FriendList> findAllFriendList(String name, Pageable pageable);
    Page<IUserDto> findAllFriendList(String name,Pageable pageable);
}
