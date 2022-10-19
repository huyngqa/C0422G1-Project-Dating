package com.codegym.dating.service;

import com.codegym.dating.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostService {
    void save(Post post);
}
