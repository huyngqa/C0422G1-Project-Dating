package com.codegym.dating.service;


import com.codegym.dating.dto.IPostDto;
import com.codegym.dating.dto.PostDto;
import com.codegym.dating.model.Post;

import java.util.List;


public interface IPostService {
    List<IPostDto> getPostList(int id);
    Post findPostById(int id);
    void updatePost(Post post);
}
