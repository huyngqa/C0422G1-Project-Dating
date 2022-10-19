package com.codegym.dating.repository;

import com.codegym.dating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
