package com.codegym.dating.repository;

import com.codegym.dating.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IAccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT * FROM account where password like :password", nativeQuery = true)
    Account findByPassword(String password);

    @Modifying
    @Transactional
    @Query(value = "UPDATE account SET password = :#{#account.password} where id_account = :#{#account.idAccount}", nativeQuery = true)
    void updatePassword(Account account);

}
