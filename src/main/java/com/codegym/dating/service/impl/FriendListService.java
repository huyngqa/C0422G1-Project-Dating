package com.codegym.dating.service.impl;

import com.codegym.dating.dto.FriendListDto;
import com.codegym.dating.dto.RelationshipDto;
import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.User;
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
    public List<UserDto> findAllRequest(int id) {
        return friendListRepository.findAllRequestFriend(id);
    }

    @Override
    public String checkFriend(Integer idUser1, Integer idUser2) {
        RelationshipDto relationshipDto = this.friendListRepository.checkFriend(idUser1,idUser2);
        if (relationshipDto == null) {
            return "Chưa có quan hệ";
        } else if (relationshipDto.getStatus() == 6) {
            return "Bạn bè";
        } else if (relationshipDto.getStatus() == 7) {
            return "Bị chặn";
        } else if (relationshipDto.getStatus() == 5 && relationshipDto.getIdUser1() == idUser1) {
            return "Đã gửi lời mời kết bạn";
        } else{
            return "Đã nhận lời mời";
        }
    }

    @Override
    public void addRequest(Integer idUser1, Integer idUser2) {
        this.friendListRepository.addRequest(idUser1,idUser2);
    }

    @Override
    public void removeRequest(Integer idUser1, Integer idUser2) {
        this.friendListRepository.removeRequest(idUser1,idUser2);
    }

    @Override
    public List<UserDto> requestSuggest(Integer idUser) {
        return friendListRepository.suggestRequest(idUser);
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
