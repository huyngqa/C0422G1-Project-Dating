package com.codegym.dating.repository;

import com.codegym.dating.model.TypeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeUserRepository extends JpaRepository<TypeUser, Integer> {
}
