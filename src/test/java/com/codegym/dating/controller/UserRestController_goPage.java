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
public class UserRestController_goPage {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPage() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/pageSearch/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getPage_search_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/public/pageSearch/?name=", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getPage_search_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/public/pageSearch/?name=" +"@$$#"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getPage_search_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/public/pageSearch/?name=" +"tradsdfasffgfggggggggggggggggggggggggggggggggasawertwetttttttttttttttttttttttt"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getPage_page_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/pageSearch?page=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(4))
                .andExpect(jsonPath("totalElements").value(20))
                .andExpect(jsonPath("content[4].name").value("Lê Hồng Phú"))
                .andExpect(jsonPath("content[4].gender").value("true"))
                .andExpect(jsonPath("content[4].address").value("K123/45 Lê Lợi, Hồ Chí Minh"))
                .andExpect(jsonPath("content[4].coin").value("5773"))
                .andExpect(jsonPath("content[4].avatar").value("chuacoanh"))
                .andExpect(jsonPath("content[4].job").value("Nhân Viên Bán Hàng"));
    }

}
