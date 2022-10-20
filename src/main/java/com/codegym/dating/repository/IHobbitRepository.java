package com.codegym.dating.repository;

import com.codegym.dating.model.Hobbit;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IHobbitRepository extends JpaRepository<Hobbit, Integer> {

}
