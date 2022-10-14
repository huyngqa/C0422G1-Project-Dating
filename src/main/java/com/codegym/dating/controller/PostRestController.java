package com.codegym.dating.controller;

import com.codegym.dating.dto.PostDto;
import com.codegym.dating.model.Post;
import com.codegym.dating.repository.IPostRepository;
import com.codegym.dating.service.IPostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("api/users/posts")
public class PostRestController {
    @Autowired
    private IPostService iPostService;

    @Autowired
    private IPostRepository iPostRepository;
    @PostMapping("/save")
    public ResponseEntity<Void> savePost(@RequestBody @Valid PostDto postDto, BindingResult bindingResult){
        new PostDto().validate(postDto, bindingResult);
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
        Post post = new Post();
        BeanUtils.copyProperties(postDto,post);
        iPostService.save(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
