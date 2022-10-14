package com.codegym.dating.service;

<<<<<<< HEAD
import com.codegym.dating.dto.PostDto;
import com.codegym.dating.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

=======
>>>>>>> 867f5fee73442869452d1acf9c01a1c5f8e40d61
public interface IPostService {
    List<PostDto> getPostList(int id);
    Post findPostById(int id);
}
