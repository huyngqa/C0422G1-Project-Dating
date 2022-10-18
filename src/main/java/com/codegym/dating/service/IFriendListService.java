package com.codegym.dating.service;

import com.codegym.dating.dto.FriendListDto;
import com.codegym.dating.model.FriendList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFriendListService {
    boolean checkFriend(Integer idUser1, Integer idUser2);
    String checkFriend1(Integer idUser1, Integer idUser2);
    int checkFriend2(Integer idUser1, Integer idUser2);
    void addRequest(Integer idUser1, Integer idUser2);

}
