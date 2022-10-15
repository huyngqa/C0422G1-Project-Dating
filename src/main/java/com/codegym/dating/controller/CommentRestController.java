package com.codegym.dating.controller;

import com.codegym.dating.model.Comment;
import com.codegym.dating.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/comment")
public class CommentRestController {

    @Autowired
    private ICommentService commentService;

    @PostMapping("/add_comment")
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params) {
        try {

//            Comment comment = this.commentService.addComment();

//            return new ResponseEntity<>(comment,HttpStatus.OK);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
