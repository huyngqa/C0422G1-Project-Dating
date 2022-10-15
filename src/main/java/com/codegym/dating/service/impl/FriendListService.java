package com.codegym.dating.dto;

import com.codegym.dating.dto.IFriendListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendListService implements IFriendListService {
    @Autowired
    private IFriendListRepository iFriendListRepository;

    @Override
    public boolean checkRelationship(Integer idUser1, Integer idUser2) {
        RelationshipDto relationshipDto = this.iFriendListRepository.findRelationship(idUser1, idUser2);
        if (relationshipDto == null) {
            return false;
        }
        return true;
    }

    @Override
    public void addRequest(Integer idUser1, Integer idUser2) {
        this.iFriendListRepository.addRequest(idUser1,idUser2);
    }

}
