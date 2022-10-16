package com.codegym.dating.repository;

import com.codegym.dating.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ICommentRepository extends JpaRepository<Comment, Integer> {


    @Modifying
    @Query(value = "insert into comment(`content`,`id_post`,`id_user`)\n" +
            "values (:content,:id_post,:id_user)", nativeQuery = true)
    void addComment(@Param("content") String content, @Param("id_post") Integer post, @Param("id_user") Integer idUser);


    @Query(value = "select * from comment c\n" +
            "join post p \n" +
            "on c.id_post = p.id_post \n" +
            "join user u \n" +
            "on c.id_user = u.id_user\n" +
            "where p.id_post = :id_post ;", nativeQuery = true)
    List<Comment> displayComment(@Param("id_post") Integer id_post);
}
