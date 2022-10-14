package com.codegym.dating.service;

import com.codegym.dating.dto.PostDto;
import com.codegym.dating.model.User;

import java.util.List;

public interface IUserService {
    User findUserByIdAccount(Integer idAccount);
}
