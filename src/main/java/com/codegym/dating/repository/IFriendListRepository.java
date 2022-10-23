package com.codegym.dating.repository;

import com.codegym.dating.dto.RelationshipDto;
import com.codegym.dating.dto.UserClassDto;
import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.FriendList;
import com.codegym.dating.projection_dto.IUserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IFriendListRepository extends JpaRepository<FriendList, Integer> {

        @Query(value = "select * from user where id_user not in(select fl.id_user2 from friend_list fl\n" +
                "where id_user1 = 1\n" +
                "union\n" +
                "select fl.id_user1 from friend_list fl\n" +
                "where id_user2 = 1)and (user.married = 0) and id_user <>1 \n" +
                "limit 6;"
                ,nativeQuery = true)
        List<UserClassDto> suggestRequest(Integer userId);

        @Modifying
        @Query(value = "INSERT INTO `dating_c04`.`friend_list` (`status`, `id_user1`, `id_user2`) VALUES ('5', ?1, ?2)", nativeQuery = true)
        void addRequest(Integer idUser1, Integer idUser2);

        @Query(value = "SELECT \n" +
                "    id, status, id_user1 AS idUser1, id_user2 AS idUser2\n" +
                "FROM\n" +
                "    friend_list\n" +
                "WHERE\n" +
                "    id_user1 IN (?1 , ?2)\n" +
                "        AND id_user2 IN (?1 , ?2)", nativeQuery = true)
        RelationshipDto checkFriend(Integer idUser1, Integer idUser2);


    @Query(value = "SELECT \n" +
            "    id_user as idUser,\n" +
            "    name,\n" +
            "    avatar,\n" +
            "    gender,\n" +
            "    (DATEDIFF(CURDATE(), date_of_birth) DIV 365) AS age\n" +
            "FROM\n" +
            "    user\n" +
            "WHERE\n" +
            "    id_user IN (SELECT \n" +
            "            id_user1\n" +
            "        FROM\n" +
            "            friend_list\n" +
            "        WHERE\n" +
            "            status = 5 AND id_user2 = ?1)", nativeQuery = true)
    List<UserDto> findAllRequestFriend(Integer id);

        @javax.transaction.Transactional
        @Modifying
        @Query(value = "   update friend_list\n" +
                "            set status = 6\n" +
                "            where status = 5 and ((id_user1=?1 and id_user2 = ?2) or (id_user1=?2 and id_user2 = ?1))", nativeQuery = true)
        void acceptRequest(@Param("idUser1") Integer idUser1, @Param("idUser2") Integer idUser2);


        @javax.transaction.Transactional
        @Modifying
        @Query(value = "delete from friend_list \n" +
                "            where status = 5 and ((id_user1=?1 and id_user2 = ?2) or (id_user1=?2 and id_user2 = ?1));", nativeQuery = true)
        void deniedRequest(@Param("idUser1") Integer idUser1, @Param("idUser2") Integer idUser2);



        @Modifying
        @Query(value = "delete from friend_list\n" +
                "        where (id_user1 = ?1 and id_user2 = ?2)", nativeQuery = true)
        void removeRequest(Integer idUser1, Integer idUser2);

    @Query(value = "select user.id_user as idUser, user.name,  (DATEDIFF(CURDATE(), user.date_of_birth) div 365)  as age, user.avatar from \n" +
            "(select id_user1 from \n" +
            "(select * from friend_list  where (friend_list.id_user1=?1 or friend_list.id_user2 = ?1) and (friend_list.status = 6 or friend_list.status = 7 ) ) as temp1 where id_user1 <> ?1\n" +
            " union \n" +
            " select id_user2 from \n" +
            "(select * from friend_list  where (friend_list.id_user1=?1 or friend_list.id_user2 = ?1) and (friend_list.status = 6 or friend_list.status = 7 ) ) as temp2 where id_user2 <> ?1) as temp3 left join user on temp3.id_user1 = user.id_user\n" +
            "where user.name like ?2", nativeQuery = true, countQuery = "select user.id_user as idUser, user.name,  (DATEDIFF(CURDATE(), user.date_of_birth) div 365)  as age, user.avatar from \n" +
            "(select id_user1 from \n" +
            "(select * from friend_list  where (friend_list.id_user1=?1 or friend_list.id_user2 = ?1) and (friend_list.status = 6 or friend_list.status = 7 )  ) as temp1 where id_user1 <> ?1\n" +
            " union \n" +
            " select id_user2 from \n" +
            "(select * from friend_list  where (friend_list.id_user1=?1 or friend_list.id_user2 = ?1) and (friend_list.status = 6 or friend_list.status = 7 )  ) as temp2 where id_user2 <> ?1) as temp3 left join user on temp3.id_user1 = user.id_user\n" +
            "where user.name like ?2")
    Page<IUserDto> findAllListFriend(Integer id ,String name, Pageable pageable);

    @Modifying
    @Query(value = "update friend_list " +
            "set status = 7 " +
            "where id_user1 in (?1, ?2) and id_user2 in (?1, ?2) ", nativeQuery = true)
    void blockFriend(Integer idUser1, Integer idUser2);

    @Modifying
    @Query(value = "delete from friend_list where id_user1 in (?1,?2) and id_user2 in  (?1,?2)", nativeQuery = true)
    void deleteFriend(Integer idUser1, Integer idUser2);
}
