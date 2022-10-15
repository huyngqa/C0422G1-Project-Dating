package com.codegym.dating.service;

import com.codegym.dating.dto.FriendListDto;
import com.codegym.dating.model.FriendList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IFriendListService {
    List<FriendListDto> findAllRequest(int id);
    void acceptRequest();
    void deniedRequest();
}
