package com.codegym.dating.repository;

import com.codegym.dating.dto.FriendListDto;
import com.codegym.dating.dto.RelationshipDto;
import com.codegym.dating.model.FriendList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IFriendListRepository extends JpaRepository<FriendList, Integer> {
        @Query(value = "SELECT \n" +
                "    id, status, id_user1 AS idUser1, id_user2 AS idUser2\n" +
                "FROM\n" +
                "    friend_list\n" +
                "WHERE\n" +
                "    id_user1 IN (?1 , ?2)\n" +
                "        AND id_user2 IN (?1 , ?2)", nativeQuery = true)
        RelationshipDto checkFriend(Integer idUser1, Integer idUser2);


        @Modifying
        @Query(value = "INSERT INTO `dating_c04`.`friend_list` (`status`, `id_user1`, `id_user2`) VALUES ('5', ?1, ?2)", nativeQuery = true)
        void addRequest(Integer idUser1, Integer idUser2);

        @Modifying
        @Query(value = "delete from friend_list\n" +
                "        where (id_user1 = ?1 and id_user2 = ?2)", nativeQuery = true)
        void removeRequest(Integer idUser1, Integer idUser2);

}



