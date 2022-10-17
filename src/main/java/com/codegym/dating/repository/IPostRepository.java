package com.codegym.dating.repository;

import com.codegym.dating.dto.IPostDto;
import com.codegym.dating.dto.PostDto;
import com.codegym.dating.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IPostRepository extends JpaRepository<Post, Integer> {
    @Query(value = "select p.content as ContentDto,\n" +
            "        p.id_user as IdDto,\n" +
            "        p.media as MediaDto,\n" +
            "         p.time as TimeDto\n" +
            "from post as p\n" +
            "where p.id_user = ?1 or p.id_user in\n" +
            " ( \n" +
            " select f.id_user2\n" +
            " from user as u\n" +
            "  left join friend_list as f  on u.id_user=f.id_user1\n" +
            "   where f.status = 6 and u.id_user= ?1\n" +
            "   group by f.id_user2)", nativeQuery = true)
    List<IPostDto> getPostList(int id);



    @Query(value = "select p.content as ContentDto,\n" +
            "        p.id_user as IdDto,\n" +
            "        p.media as MediaDto,\n" +
            "         p.time as TimeDto\n" +
            "from post as p\n" +
            "where p.id_user = ?1", nativeQuery = true)
    List<IPostDto> getUserPostList(int id);

    @Query(value = "select p.id_post, p.id_user,p.content,p.media,p.time\n" +
            "from post as p\n" +
            "where p.id_post = 1", nativeQuery = true)
    Post findPostById(int id);

    @Modifying
    @Query(value = "update post as p \n" +
            "            set p.content= ?1,p.media= ?2\n" +
            "            where p.id_user= ?3 and p.id_post= ?4", nativeQuery = true)
    void updatePost(String content, String media, int idUserUp, int idPostUp);
}
