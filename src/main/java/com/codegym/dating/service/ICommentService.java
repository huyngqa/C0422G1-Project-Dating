package com.codegym.dating.service;

import com.codegym.dating.model.Comment;

import java.util.List;

public interface ICommentService {

    void addComment(Comment comments);

    List<Comment> displayComment(Integer idPost);

}
