package com.codegym.dating.service.impl;

import com.codegym.dating.repository.ICommentRepository;
import com.codegym.dating.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private ICommentRepository iCommentRepository;


}
