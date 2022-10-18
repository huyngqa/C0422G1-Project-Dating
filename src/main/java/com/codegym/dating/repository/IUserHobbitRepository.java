package com.codegym.dating.repository;

import com.codegym.dating.model.UserHobbit;
import com.codegym.dating.model.composite.UserHobbitKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserHobbitRepository extends JpaRepository<UserHobbit, UserHobbitKey> {
}
