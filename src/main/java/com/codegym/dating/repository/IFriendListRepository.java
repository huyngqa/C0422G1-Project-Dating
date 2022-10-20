package com.codegym.dating.repository;

import com.codegym.dating.model.FriendList;
import com.codegym.dating.projection_dto.IUserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IFriendListRepository extends JpaRepository<FriendList, Integer> {

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
