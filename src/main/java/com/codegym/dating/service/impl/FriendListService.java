package com.codegym.dating.service.impl;

import com.codegym.dating.dto.FriendListDto;
import com.codegym.dating.dto.RelationshipDto;
import com.codegym.dating.dto.UserDto;
import com.codegym.dating.repository.IFriendListRepository;
import com.codegym.dating.service.IFriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendListService implements IFriendListService {
    @Autowired
    private IFriendListRepository iFriendListRepository;
    @Override
    public boolean checkFriend(Integer idUser1, Integer idUser2) {
        RelationshipDto relationshipDto = this.iFriendListRepository.checkFriend(idUser1,idUser2);
       if (relationshipDto == null) {
           return false;
       }
       return true;
    }

    @Override
    public String checkFriend1(Integer idUser1, Integer idUser2) {
        RelationshipDto relationshipDto = this.iFriendListRepository.checkFriend(idUser1,idUser2);
        if (relationshipDto == null) {
            return "Chưa có quan hệ"; //0
        } else if (relationshipDto.getStatus() == 5) {
                return "Đã gửi lời mời";//5
        } else if (relationshipDto.getStatus() == 6) {
            return "Bạn bè";//6
        } else  if (relationshipDto.getStatus() == 7){
            return "Bị chặn";//7
        }
        return "";
    }

    @Override
    public int checkFriend2(Integer idUser1, Integer idUser2) {
        RelationshipDto relationshipDto = this.iFriendListRepository.checkFriend(idUser1, idUser2);
        if (relationshipDto == null) {
            return 0;//"Chưa có quan hệ"
        } else if (relationshipDto.getStatus() == 6) {
            return 6;//"Bạn bè"
        } else if (relationshipDto.getStatus() == 7) {
            return 7; //Bị chặn
        } else if (relationshipDto.getStatus() == 5 && relationshipDto.getIdUser1() == idUser1) {
            return 51; //User 1 gửi lời mời kết bạn
        }
        return 52; //User2 gửi lời mời kết bạn

    }
    @Override
    public void addRequest(Integer idUser1, Integer idUser2) {
        this.iFriendListRepository.addRequest(idUser1,idUser2);
    }
}
