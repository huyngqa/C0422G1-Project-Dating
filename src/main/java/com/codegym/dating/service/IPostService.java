package com.codegym.dating.service;

import com.codegym.dating.dto.PostDto;
import com.codegym.dating.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostService {
    List<PostDto> getPostList(int id);
    Post findPostById(int id);
}
