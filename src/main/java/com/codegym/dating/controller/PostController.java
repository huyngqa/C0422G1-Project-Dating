package com.codegym.dating.controller;

import com.codegym.dating.dto.PostDto;
import com.codegym.dating.model.Post;
import com.codegym.dating.service.IPostService;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    IPostService iPostService;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<PostDto>> getList(@PathVariable int id) {
        List<PostDto> list = this.iPostService.getPostList(id);
        if( list.isEmpty()){
            return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }

    @GetMapping("/findPost/{id}")
    public  ResponseEntity<Post> findByIdPost(@PathVariable int id){
        Post post = this.iPostService.findPostById(id);
        if (post == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(post,HttpStatus.OK);
        }
    }
    @PatchMapping("/update")
    public ResponseEntity<Void> updatePost(@RequestBody Post post){
        this.iPostService.updatePost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
