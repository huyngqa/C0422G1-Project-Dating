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
    public String checkFriend(Integer idUser1, Integer idUser2) {
        RelationshipDto relationshipDto = this.iFriendListRepository.checkFriend(idUser1,idUser2);
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

<<<<<<< HEAD
=======

>>>>>>> 9ab891bb082b3cdb0744d4addb20f6dfdd52788a
    @Override
    public void addRequest(Integer idUser1, Integer idUser2) {
        this.iFriendListRepository.addRequest(idUser1,idUser2);
    }

    @Override
    public void removeRequest(Integer idUser1, Integer idUser2) {
        this.iFriendListRepository.removeRequest(idUser1,idUser2);
    }
<<<<<<< HEAD

=======
>>>>>>> 9ab891bb082b3cdb0744d4addb20f6dfdd52788a
}
