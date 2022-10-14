package com.codegym.dating.repository;

import com.codegym.dating.model.Post;
import com.codegym.dating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Transactional
public interface IPostRepository extends JpaRepository<Post, Integer> {
    @Modifying
    @Query(value = " INSERT INTO post ( `content` , `media` , `time` , `id_user`)" +
            " VALUES (:content, :media, :time, :id_user) ",
            nativeQuery = true)
    void savePost(@Param("content") String content, @Param("media") String media, @Param("time") LocalDateTime time,
                  @Param("id_user") Integer id);


}

