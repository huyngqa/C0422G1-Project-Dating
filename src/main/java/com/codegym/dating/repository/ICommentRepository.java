package com.codegym.dating.repository;

import com.codegym.dating.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ICommentRepository extends JpaRepository<Comment, Integer> {


    @Modifying
    @Query(value = "Insert into comment(content,id_post,id_user) \n" +
            "values (:content,:post,:id_user);", nativeQuery = true)
    Comment addComment(@Param("content") String content , @Param("post") Integer post , @Param("id_user") Integer idUser);
}
