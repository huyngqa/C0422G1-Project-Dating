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
public class RequestListRestController {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Không có tham số nên không xác định được ai là người nhận
    @Test
    public void getListRequest1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/users/request/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    // Không có tham số nên không xác định được ai là người nhận
    @Test
    public void getListRequest_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/users/request/{id}",null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Lấy được list của khách hàng có user có id=1
    @Test
    public void getListRequest_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/users/request/{id}","1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
