package com.codegym.dating.service.impl;

import com.codegym.dating.dto.IPostDto;
import com.codegym.dating.model.Post;
import com.codegym.dating.repository.IPostRepository;
import com.codegym.dating.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService  implements IPostService {
    @Autowired
    IPostRepository iPostRepository;
    @Override
    public List<IPostDto> getPostList(int id) {
        return this.iPostRepository.getPostList(id);
    }

    @Override
    public IPostDto findPostById(int id) {
        return this.iPostRepository.findPostById(id);
    }

    @Override
    public void updatePost(Post post) {
        this.iPostRepository.updatePost(post.getContent(),post.getMedia() ,post.getUser().getIdUser(),post.getIdPost());
    }

    @Override
    public List<IPostDto> getUserPostList(int id) {
        return this.iPostRepository.getUserPostList(id);
    }
}
