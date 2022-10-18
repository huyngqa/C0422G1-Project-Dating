package com.codegym.dating.controller;

import com.codegym.dating.dto.ClassCommentDto;
import com.codegym.dating.dto.ClassPostDto;
import com.codegym.dating.dto.ClassUserDto;
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
public class CommentController_CreateComment {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void CreateComment_content_13() throws Exception {


        ClassCommentDto commentDto = new ClassCommentDto();

        commentDto.setContent(null);

        ClassUserDto classUserDto = new ClassUserDto();
        classUserDto.setIdUser(3);
        commentDto.setUserDto(classUserDto);

        ClassPostDto classPostDto = new ClassPostDto();
        classPostDto.setIdPost(1);
        commentDto.setPostDto(classPostDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/users/add_comment")
                        .content(this.objectMapper.writeValueAsString(commentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void CreateComment_content_14() throws Exception {

        ClassCommentDto commentDto = new ClassCommentDto();

        commentDto.setContent("");

        ClassUserDto classUserDto = new ClassUserDto();
        classUserDto.setIdUser(3);
        commentDto.setUserDto(classUserDto);

        ClassPostDto classPostDto = new ClassPostDto();
        classPostDto.setIdPost(1);
        commentDto.setPostDto(classPostDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/users/add_comment")
                        .content(this.objectMapper.writeValueAsString(commentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void CreateComment_content_18() throws Exception {

        ClassCommentDto commentDto = new ClassCommentDto();

        commentDto.setContent("hôm nay trời nắng đẹp");

        ClassUserDto classUserDto = new ClassUserDto();
        classUserDto.setIdUser(3);
        commentDto.setUserDto(classUserDto);

        ClassPostDto classPostDto = new ClassPostDto();
        classPostDto.setIdPost(1);
        commentDto.setPostDto(classPostDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/users/add_comment")
                        .content(this.objectMapper.writeValueAsString(commentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
