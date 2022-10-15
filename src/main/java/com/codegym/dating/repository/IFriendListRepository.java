package com.codegym.dating.repository;

import com.codegym.dating.dto.FriendListDto;
import com.codegym.dating.model.FriendList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
            "    status = 6 AND id_user1 = ?1",nativeQuery = true)
    List<FriendListDto> findAllRequestFriend(Integer id);

    @Query(value = "SET SQL_SAFE_UPDATES = 0;\n" +
            "SET FOREIGN_KEY_CHECKS =0;\n" +
            "update friend_list \n" +
            "set status = 6\n" +
            "where status = 5 and ((id_user1=?1 and id_user2 = ?2) or (id_user1=?2 and id_user2 = ?1));\n" +
            "SET FOREIGN_KEY_CHECKS = 1;\n" +
            "SET SQL_SAFE_UPDATES = 1",nativeQuery = true)
    void acceptRequest();

    @Query(value = "SET SQL_SAFE_UPDATES = 0;\n" +
            "SET FOREIGN_KEY_CHECKS =0;\n" +
            "delete from friend_list \n" +
            "where status = 6 and ((id_user1=?1 and id_user2 = ?2) or (id_user1=?2 and id_user2 = ?1));\n" +
            "SET FOREIGN_KEY_CHECKS = 1;\n" +
            "SET SQL_SAFE_UPDATES = 1;",nativeQuery = true)
    void deniedRequest();
}
