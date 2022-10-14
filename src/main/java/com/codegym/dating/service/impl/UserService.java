package com.codegym.dating.service.impl;

<<<<<<< HEAD
import com.codegym.dating.dto.PostDto;
=======
import com.codegym.dating.model.User;
>>>>>>> 867f5fee73442869452d1acf9c01a1c5f8e40d61
import com.codegym.dating.repository.IUserRepository;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.List;

@Service
public class UserService implements IUserService {

=======
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public User findUserByIdAccount(Integer idAccount) {
        return iUserRepository.findByAccount_IdAccount(idAccount);
    }
>>>>>>> 867f5fee73442869452d1acf9c01a1c5f8e40d61
}
