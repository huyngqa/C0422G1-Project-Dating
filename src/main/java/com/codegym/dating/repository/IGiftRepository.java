package com.codegym.dating.repository;

import com.codegym.dating.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGiftRepository extends JpaRepository<Gift, Integer> {
}
