package com.codegym.dating.dto;

import com.codegym.dating.dto.RelationshipDto;
import com.codegym.dating.model.FriendList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFriendListService {
    boolean checkRelationship(Integer idUser1, Integer idUser2);
    void addRequest(Integer idUser1, Integer idUser2);

}
