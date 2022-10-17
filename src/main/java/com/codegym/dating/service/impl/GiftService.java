package com.codegym.dating.service.impl;

import com.codegym.dating.model.Gift;
import com.codegym.dating.repository.IGiftRepository;
import com.codegym.dating.service.IGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftService implements IGiftService {

    @Autowired
    private IGiftRepository giftRepository;

    @Override
    public List<Gift> findAllGift() {
        return giftRepository.findAllGift();
    }
}
