package com.codegym.dating.controller;

import com.codegym.dating.dto.IPostDto;
import com.codegym.dating.dto.PostDto;
import com.codegym.dating.model.Post;
import com.codegym.dating.service.IPostService;

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
@RequestMapping("/post")
public class PostController {
    @Autowired
    IPostService iPostService;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<IPostDto>> getList(@PathVariable int id) {
        List<IPostDto> list = this.iPostService.getPostList(id);
        if(list.isEmpty()){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }

    @GetMapping("/findPost/{id}")
    public  ResponseEntity<Post> findByIdPost(@PathVariable int id){
        Post post = this.iPostService.findPostById(id);

        if (post == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(post,HttpStatus.OK);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<Void> updatePost( @RequestBody @Valid PostDto postDto,
                                           BindingResult bindingResult){
        Post post = new Post();
         Post post1 = this.iPostService.findPostById(postDto.getIdPost());
          new PostDto().validate(postDto,bindingResult);
          if (bindingResult.hasErrors() || post1 == null ){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         } else {
             BeanUtils.copyProperties(postDto, post);
             this.iPostService.updatePost(post);
             return new ResponseEntity<>(HttpStatus.OK);
         }
    }
}
