package com.codegym.dating.service;

import com.codegym.dating.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGiftService {
    List<Gift> findAllGift();
}
