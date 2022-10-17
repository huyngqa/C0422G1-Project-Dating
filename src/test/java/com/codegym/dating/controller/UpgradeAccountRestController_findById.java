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
public class UpgradeAccountRestController_findById {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findById_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/users/posts/detailUser/{idUser}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findById_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/users/posts/detailUser/{idUser}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findById_id_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/users/posts/detailUser/{idUser}", "100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findById_id_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/users/upgradeAccount/detailUser/{idUser}", "9"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("idUser").value(9))
                .andExpect(jsonPath("name").value("Huỳnh Quốc Trung"))
                .andExpect(jsonPath("dateOfBirth").value("1999-04-08"))
                .andExpect(jsonPath("avatar").value("chuacoanh"))
                .andExpect(jsonPath("address").value("224 Lý Thái Tổ, Gia Lai"))
                .andExpect(jsonPath("coin").value("44492"))
                .andExpect(jsonPath("gender").value(true))
                .andExpect(jsonPath("job").value("Đầu Bếp"))
                .andExpect(jsonPath("joinDay").value("2018-11-11"))
                .andExpect(jsonPath("married").value(false))
                .andExpect(jsonPath("typeUser.idTypeUser").value(2));
    }
}
