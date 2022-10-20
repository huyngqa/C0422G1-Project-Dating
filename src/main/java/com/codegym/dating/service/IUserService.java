package com.codegym.dating.service;

import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.User;
import com.codegym.dating.payload.request.UpdateStatusRequest;
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
    Page<User> findAll(String name,Pageable pageable);

    Page<User> findByTypeUser(String name, String typeUser,Pageable pageable);

    Optional<User> findByIdUser(int id);

    void updateWarningUser(UpdateStatusRequest updateStatusRequest);
}
