package com.codegym.dating.repository;

import com.codegym.dating.dto.PostDto;
import com.codegym.dating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer> {
<<<<<<< HEAD


=======
    User findByAccount_IdAccount(Integer idAccount);
>>>>>>> 867f5fee73442869452d1acf9c01a1c5f8e40d61
}
