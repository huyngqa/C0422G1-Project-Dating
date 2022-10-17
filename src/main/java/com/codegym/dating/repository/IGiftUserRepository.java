package com.codegym.dating.repository;

import com.codegym.dating.model.GiftUser;
import com.codegym.dating.model.composite.GiftUserKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IGiftUserRepository extends JpaRepository<GiftUser, GiftUserKey> {

    @Query(value = "select * from gift_user", nativeQuery = true)
    List<GiftUser> findAllGiftUser();

    @Modifying
    @Transactional
    @Query(value = "update gift_user set quantity = quantity + :quantity where id_gift = :idGift && id_user_receiver = :idUserReceiver && id_user_sender = :idUserSender ", nativeQuery = true)
    void updateGiveAGift(@Param("idGift") Integer idGift, @Param("idUserReceiver") Integer idUserReceiver, @Param("idUserSender") Integer idUserSender, @Param("quantity") Integer quantity);

    @Modifying
    @Transactional
    @Query(value = "insert into gift_user (id_gift, id_user_receiver, id_user_sender, quantity) " +
            " value (:idGift, :idUserReceiver, :idUserSender, :quantity) ", nativeQuery = true)
    void saveGiveAGift(@Param("idGift") Integer idGift, @Param("idUserReceiver") Integer idUserReceiver, @Param("idUserSender") Integer idUserSender, @Param("quantity") Integer quantity);

}
