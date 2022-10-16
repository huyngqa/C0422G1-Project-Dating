package com.codegym.dating.repository;

import com.codegym.dating.model.UserHobbit;
import com.codegym.dating.model.composite.UserHobbitKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IUserHobbitRepository extends JpaRepository<UserHobbit, UserHobbitKey> {

    @Transactional
    @Modifying
    @Query(value = "insert into user_has_hobbit(id_user, id_hobbit) " +
            "value (:#{#userHobbit.id.idUser}, :#{#userHobbit.id.idHobbit})", nativeQuery = true)
    void saveUserHobbit(UserHobbit userHobbit);
}
