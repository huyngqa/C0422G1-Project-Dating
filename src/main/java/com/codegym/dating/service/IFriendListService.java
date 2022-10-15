package com.codegym.dating.service;

import com.codegym.dating.model.FriendList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface IFriendListService {
    boolean checkRelationship(Integer idUser1, Integer idUser2);
    void addRequest(Integer idUser1, Integer idUser2);
}
