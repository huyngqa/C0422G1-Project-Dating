package com.codegym.dating.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRestController_search {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void userPage_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/users/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void userPage_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/users?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(4))
                .andExpect(jsonPath("totalElements").value(20))
                .andExpect(jsonPath("content[4].idUser").value(10))
                .andExpect(jsonPath("content[4].name").value("Lê Hồng Phú"))
                .andExpect(jsonPath("content[4].dateOfBirth").value("1994-07-01"));
    }

}
