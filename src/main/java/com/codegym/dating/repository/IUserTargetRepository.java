package com.codegym.dating.repository;

import com.codegym.dating.model.UserTarget;
import com.codegym.dating.model.composite.UserTargetKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserTargetRepository extends JpaRepository<UserTarget, UserTargetKey> {
}
