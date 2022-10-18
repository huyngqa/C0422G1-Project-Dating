package com.codegym.dating.service;

import com.codegym.dating.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    Page<UserDto> findAllPage(Pageable pageable);

    List<UserDto> findAllSearch(String name);
}
