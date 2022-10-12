package com.codegym.dating.repository;

import com.codegym.dating.model.GiftUser;
import com.codegym.dating.model.composite.GiftUserKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGiftUserRepository extends JpaRepository<GiftUser, GiftUserKey> {
}
