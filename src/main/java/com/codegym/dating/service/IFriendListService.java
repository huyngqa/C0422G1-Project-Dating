package com.codegym.dating.service;

import com.codegym.dating.dto.FriendListDto;
import com.codegym.dating.model.FriendList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFriendListService {
    String checkFriend(Integer idUser1, Integer idUser2);
    void addRequest(Integer idUser1, Integer idUser2);
    void removeRequest(Integer idUser1, Integer idUser2);

}
