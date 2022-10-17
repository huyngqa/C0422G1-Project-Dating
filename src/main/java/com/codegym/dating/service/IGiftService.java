package com.codegym.dating.service;

import com.codegym.dating.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IGiftService {
    List<Gift> findAllGift();

    Optional<Gift> findById(Integer idGift);
}
