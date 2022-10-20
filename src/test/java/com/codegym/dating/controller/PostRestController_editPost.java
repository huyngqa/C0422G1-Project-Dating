package com.codegym.dating.controller;

import com.codegym.dating.dto.PostDto;
import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostRestController_editPost {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;


    // id không có trong database
    @Test
    public void updatePost_19() throws Exception{
       PostDto postDto = new PostDto();
       postDto.setContent("Thai");
       postDto.setIdPost(30);
       postDto.setMedia("http//21323213");
       postDto.setTime(LocalDateTime.now());
        User user = new User();
        user.setIdUser(30);
        postDto.setUser(user);
       this.mockMvc.perform(MockMvcRequestBuilders
                       .patch("/post/update")
                       .content(this.objectMapper.writeValueAsString(postDto))
                       .contentType(MediaType.APPLICATION_JSON_VALUE))
               .andDo(print())
               .andExpect(status().is4xxClientError());
    }


    // id hợp lệ
    @Test
    public void updatePost_20() throws Exception{
        PostDto postDto = new PostDto();
        postDto.setContent("Thai000");
        postDto.setIdPost(2);
        postDto.setMedia("http//21323213");
        postDto.setTime(LocalDateTime.now());
        User user = new User();
        user.setIdUser(2);
        postDto.setUser(user);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/post/update")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}
