package com.codegym.dating.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRestController_search {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void userPage_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/users"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void userPage_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/users?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(20))
                .andExpect(jsonPath("content[19].idUser").value(20))
                .andExpect(jsonPath("content[19].address").value("37 Yên Thế, Đà Nẵng"))
                .andExpect(jsonPath("content[19].avatar").value("chuacoanh"))
                .andExpect(jsonPath("content[19].coin").value(2446))
                .andExpect(jsonPath("content[19].dateOfBirth").value("1997-04-09"))
                .andExpect(jsonPath("content[19].gender").value(1))
                .andExpect(jsonPath("content[19].job").value("Giáo Viên Tiếng Anh"))
                .andExpect(jsonPath("content[19].joinDay").value("2021-06-28"))
                .andExpect(jsonPath("content[19].married").value(0))
                .andExpect(jsonPath("content[19].name").value("Nguyễn Hoàng Đa Phúc"))
                .andExpect(jsonPath("content[19].statusActive").value(""))
                .andExpect(jsonPath("content[19].typeUser.idTypeUser").value(2));

    }

    @Test
    public void userPage_7() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders
                .get("/api/users"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
