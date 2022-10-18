package com.codegym.dating.service.impl;

import com.codegym.dating.model.User;
import com.codegym.dating.payload.request.UpdateStatusRequest;
import com.codegym.dating.repository.IUserRepository;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Page<User> findAll(String name, Pageable pageable) {
        return iUserRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<User> findByTypeUser(String name, String typeUser, Pageable pageable) {
        return iUserRepository.findByTypeUser(name, typeUser, pageable);
    }

    @Override
    public Optional<User> findByIdUser(int id) {
        return iUserRepository.findById(id);
    }

    @Override
    public void updateWarningUser(UpdateStatusRequest updateStatusRequest) {
        Optional<User> userOpt = this.findByIdUser(updateStatusRequest.getIdUser());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.getAccount().setStatus(updateStatusRequest.getStatus());
            iUserRepository.save(user);
        }
    }
}
