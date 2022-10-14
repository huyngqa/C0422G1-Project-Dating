package com.codegym.dating.repository;

import com.codegym.dating.model.FriendList;
import com.codegym.dating.projection_dto.IUserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFriendListRepository extends JpaRepository<FriendList, Integer> {
//    @Query(value = "select user.id_user, user.name,  (DATEDIFF(CURDATE(), user.date_of_birth) div 365)  as age, user.avatar from \n" +
//            "(select id_user1 from \n" +
//            "(select * from friend_list  where (friend_list.id_user1=1 or friend_list.id_user2 = 1) and friend_list.status = 6) as temp1 where id_user1 <> 1\n" +
//            " union \n" +
//            " select id_user2 from \n" +
//            "(select * from friend_list  where (friend_list.id_user1=1 or friend_list.id_user2 = 1) and friend_list.status = 6) as temp2 where id_user2 <> 1) as temp3 left join user on temp3.id_user1 = user.id_user",nativeQuery = true)
//    Page<FriendList> findAllListFriend(Pageable pageable);
    @Query(value = "select user.id_user as idUser, user.name,  (DATEDIFF(CURDATE(), user.date_of_birth) div 365)  as age, user.avatar from \n" +
            "(select id_user1 from \n" +
            "(select * from friend_list  where (friend_list.id_user1=1 or friend_list.id_user2 = 1) and friend_list.status = 6) as temp1 where id_user1 <> 1\n" +
            " union \n" +
            " select id_user2 from \n" +
            "(select * from friend_list  where (friend_list.id_user1=1 or friend_list.id_user2 = 1) and friend_list.status = 6) as temp2 where id_user2 <> 1) as temp3 left join user on temp3.id_user1 = user.id_user\n" +
            "where user.name like :keyword",nativeQuery = true,countQuery ="select user.id_user as idUser, user.name,  (DATEDIFF(CURDATE(), user.date_of_birth) div 365)  as age, user.avatar from \n" +
            "(select id_user1 from \n" +
            "(select * from friend_list  where (friend_list.id_user1=1 or friend_list.id_user2 = 1) and friend_list.status = 6) as temp1 where id_user1 <> 1\n" +
            " union \n" +
            " select id_user2 from \n" +
            "(select * from friend_list  where (friend_list.id_user1=1 or friend_list.id_user2 = 1) and friend_list.status = 6) as temp2 where id_user2 <> 1) as temp3 left join user on temp3.id_user1 = user.id_user\n" +
            "where user.name like :keyword" )
//    Page<FriendList> findAllListFriend(@Param("name") String name, Pageable pageable);
    Page<IUserDto> findAllListFriend(@Param("keyword") String name, Pageable pageable);
}
