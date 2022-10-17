package com.codegym.dating.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FriendRequestRestController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Lỗi 404
    @Test
    public void AcceptFriendRequest_name_20() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/users/{id}/{id}", "","1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    // Lỗi 404
    @Test
    public void AcceptFriendRequest_name_19() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/users/{id}/{id}", null,"1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Lỗi 404
    @Test
    public void AcceptFriendRequest_name_21() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/users/{id}/{id}", "n","1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void AcceptFriendRequest_name_24() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/users/{id}/{id}", "2","4"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Lỗi 404
    @Test
    public void DeniedFriendRequest_name_20() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/users/{id}/{id}", "","1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    // Lỗi 404
    @Test
    public void DeniedFriendRequest_name_19() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/users/{id}/{id}", null,"1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Lỗi 404
    @Test
    public void DeniedFriendRequest_name_21() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/users/{id}/{id}", "n","1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void DeniedFriendRequest_name_24() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/users/{id}/{id}", "2","4"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}

