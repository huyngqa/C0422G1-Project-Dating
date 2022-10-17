package com.codegym.dating.repository;

import com.codegym.dating.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGiftRepository extends JpaRepository<Gift, Integer> {
    @Query(value = "select * from gift", nativeQuery = true)
    List<Gift> findAllGift();
}
