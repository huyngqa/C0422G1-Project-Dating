package com.codegym.dating.service;

import com.codegym.dating.dto.UserClassDto;
import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<UserDto> findByIdDto(Integer id);
    User findUserById(Integer id);
    void updateCoin(Integer coin, Integer idUSer);
    void updateTypeUser(Integer coin, Integer idUser);
    Page<UserDto> findAllPage(Pageable pageable);

    List<UserDto> findAllSearch(String name);


    Page<UserDto> userPage(String name,
                                String dateOfBirth,
                                String address,
                                String job,
                                String gender,
                                String hobbitName,
                                Pageable pageable);

    Page<UserDto> findAllSearchPage(Pageable pageable, String name);



    void updateAvatar(User user);

    void updateStatusActive(User user);



}
