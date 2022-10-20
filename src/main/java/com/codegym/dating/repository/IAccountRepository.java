package com.codegym.dating.repository;

import com.codegym.dating.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT * FROM account where password like :password", nativeQuery = true)
    Account findByPassword(String password);

    @Query(value = "SELECT * FROM account where id_account =:idAccount", nativeQuery = true)
    Optional<Account> findById(@Param("idAccount") Integer idAccount);

//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE account SET password = :#{#account.password} where id_account = :#{#account.idAccount}", nativeQuery = true)
//    void updatePassword(Account account);

    @Modifying
    @Transactional
    @Query(value = "update account set password =?1 where id_account = ?2", nativeQuery = true)
    void saveNewPassword(String password, Integer idAccount);
}
