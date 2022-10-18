package com.codegym.dating.repository;

import com.codegym.dating.model.FriendList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFriendListRepository extends JpaRepository<FriendList, Integer> {
}
