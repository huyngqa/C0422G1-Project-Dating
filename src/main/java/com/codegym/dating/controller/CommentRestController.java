package com.codegym.dating.controller;

import com.codegym.dating.dto.CommentDto;
import com.codegym.dating.model.Comment;
import com.codegym.dating.service.ICommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class CommentRestController {

    @Autowired
    private ICommentService icommentService;

    @GetMapping("/display_comment/{id}")
    public ResponseEntity<List<Comment>> displayComment(@PathVariable Integer id) {

        List<Comment> comments = this.icommentService.displayComment(id);

        if (comments.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(comments, HttpStatus.OK);

    }

    @PostMapping("/add_comment")
    public ResponseEntity<?> addComment(@RequestBody @Valid CommentDto commentDto, BindingResult bindingResult) {

        new CommentDto().validate(commentDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }

        Comment comment = new Comment();

        BeanUtils.copyProperties(commentDto, comment);

        this.icommentService.addComment(comment);

        return new ResponseEntity<>( HttpStatus.OK);

    }
}
