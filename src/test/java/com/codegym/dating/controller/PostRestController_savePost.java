package com.codegym.dating.controller;

import com.codegym.dating.dto.PostDto;
import com.codegym.dating.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostRestController_savePost {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void savePost_findUserById_3() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setContent("Trung");
        postDto.setMedia("abc");

        User user = new User();
        user.setIdUser(30);
        postDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders.
                        post("/api/users/posts/save")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void savePost_content_13() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setContent(null);
        postDto.setMedia("abc");

        User user = new User();
        user.setIdUser(1);
        postDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders.
                        post("/api/users/posts/save")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void savePost_content_14() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setContent("");
        postDto.setMedia("abc");

        User user = new User();
        user.setIdUser(1);
        postDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders.
                        post("/api/users/posts/save")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void savePost_content_18() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setContent("Trung");
        postDto.setMedia("abc");

        User user = new User();
        user.setIdUser(1);
        postDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders.
                        post("/api/users/posts/save")
                        .content(this.objectMapper.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



}
