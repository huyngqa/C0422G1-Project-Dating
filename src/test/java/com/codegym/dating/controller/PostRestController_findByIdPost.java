package com.codegym.dating.controller;

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
public class PostRestController_findByIdPost {
    @Autowired
    private MockMvc mockMvc;

    //* Get findById  with id = null
    @Test
    public void findById_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/post/findPost/{id}","null"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    //* Get findById  with id = ""
    @Test
    public void findById_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/post/findPost/{id}",""))
                .andDo(print()).andExpect(status().is4xxClientError());
    }


    //* Get findById  with id not in database
    @Test
    public void findById_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/post/findPost/{id}","30"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
}
