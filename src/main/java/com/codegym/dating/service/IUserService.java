package com.codegym.dating.service;

import com.codegym.dating.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.codegym.dating.model.User;

public interface IUserService {
    Page<UserDto> findAllSearchPage(Pageable pageable, String name);
}
