package com.codegym.dating.repository;

import com.codegym.dating.dto.FriendListDto;
import com.codegym.dating.model.FriendList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface IFriendListRepository extends JpaRepository<FriendList, Integer> {

    @Query(value = "SELECT\n" +
            "    fl.id,\n" +
            "    fl.id_user2 as idUser,\n" +
            "    u.name,\n" +
            "    u.gender,\n" +
            "    (DATEDIFF(CURDATE(), u.date_of_birth) DIV 365) AS age,\n" +
            "    u.avatar\n" +
            "FROM\n" +
            "    user u\n" +
            "        JOIN\n" +
            "    friend_list fl ON fl.id_user2 = u.id_user\n" +
            "WHERE\n" +
            "    status = 6 AND id_user1 = ?1", nativeQuery = true)
    List<FriendListDto> findAllRequestFriend(Integer id);

    @Transactional
    @Modifying
    @Query(value = "   update friend_list\n" +
            "            set status = 6\n" +
            "            where status = 5 and ((id_user1=?1 and id_user2 = ?2) or (id_user1=?2 and id_user2 = ?1))", nativeQuery = true)
    void acceptRequest(@Param("idUser1") Integer idUser1, @Param("idUser2") Integer idUser2);


    @Transactional
    @Modifying
    @Query(value = "delete from friend_list \n" +
            "            where status = 5 and ((id_user1=?1 and id_user2 = ?2) or (id_user1=?2 and id_user2 = ?1));", nativeQuery = true)
    void deniedRequest(@Param("idUser1") Integer idUser1, @Param("idUser2") Integer idUser2);
}
