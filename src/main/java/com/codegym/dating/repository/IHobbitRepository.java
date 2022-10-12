package com.codegym.dating.repository;

import com.codegym.dating.model.Hobbit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHobbitRepository extends JpaRepository<Hobbit, Integer> {
}
