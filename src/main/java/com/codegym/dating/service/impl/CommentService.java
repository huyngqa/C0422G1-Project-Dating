package com.codegym.dating.service.impl;


import com.codegym.dating.model.Comment;
import com.codegym.dating.model.Post;
import com.codegym.dating.model.User;
import com.codegym.dating.repository.ICommentRepository;
import com.codegym.dating.repository.IPostRepository;
import com.codegym.dating.repository.IUserRepository;
import com.codegym.dating.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IPostRepository iPostRepository;

    @Autowired
    private ICommentRepository iCommentRepository;

    @Override
    public Comment addComment(Comment comments) {
        return this.iCommentRepository.addComment(comments.getContent(),comments.getPost().getIdPost(),comments.getUser().getIdUser());
    }
}
