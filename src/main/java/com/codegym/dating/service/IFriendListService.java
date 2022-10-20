package com.codegym.dating.service;

import com.codegym.dating.dto.FriendListDto;
import com.codegym.dating.dto.RelationshipDto;
import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.FriendList;
import com.codegym.dating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IFriendListService {
    List<UserDto> findAllRequest(int id);
    void acceptRequest(Integer idUser1 , Integer idUser2);
    void deniedRequest(Integer idUser1 , Integer idUser2);
    List<UserDto> requestSuggest(Integer userId);

    String checkFriend(Integer idUser1, Integer idUser2);
    void addRequest(Integer idUser1, Integer idUser2);
    void removeRequest(Integer idUser1, Integer idUser2);

    Page<IUserDto> findAllFriendList(Integer id, String name, Pageable pageable);

    void deleteFriend(Integer idUser, Integer[] friendList);

    void blockFriend(Integer idUser, Integer[] friendList);

}
