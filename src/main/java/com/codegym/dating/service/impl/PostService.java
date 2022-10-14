package com.codegym.dating.service.impl;
import com.codegym.dating.model.Post;
import com.codegym.dating.repository.IPostRepository;
import com.codegym.dating.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository iPostRepository;
    @Override
    public void save(Post post) {
        iPostRepository.savePost(post.getContent(),post.getMedia(),LocalDateTime.now(),post.getUser().getIdUser());
    }

}
