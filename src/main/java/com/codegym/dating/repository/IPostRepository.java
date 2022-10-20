package com.codegym.dating.repository;

import com.codegym.dating.dto.IPostDto;
import com.codegym.dating.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
public interface IPostRepository extends JpaRepository<Post, Integer> {
    @Modifying
    @Query(value = " INSERT INTO post ( `content` , `media` , `time` , `id_user`)" +
            " VALUES (:content, :media, :time, :id_user) ",
            nativeQuery = true)
    void savePost(@Param("content") String content, @Param("media") String media, @Param("time") LocalDateTime time,
                  @Param("id_user") Integer id);

    @Query(value = "SELECT \n" +
            "    p.content AS content,\n" +
            "    p.id_user AS idUser,\n" +
            "    p.media AS media,\n" +
            "    p.time AS time,\n" +
            "    p.id_post AS idPost,\n" +
            "    u.avatar AS avatar,\n" +
            "    u.name AS Username\n" +
            "FROM\n" +
            "    post AS p\n" +
            "        JOIN\n" +
            "    user AS u ON p.id_user = u.id_user\n" +
            "WHERE\n" +
            "    p.id_user = ?1 " +
            "ORDER BY time DESC", nativeQuery = true)
    List<IPostDto> getUserPostList(int id);
}
