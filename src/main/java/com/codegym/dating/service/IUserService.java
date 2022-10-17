package com.codegym.dating.service;

import com.codegym.dating.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> userPage(String name ,
                        String dateOfBirth,
                        String address,
                        String job,
                        String gender,
                        String hobbitName,
                        Pageable pageable);
}
