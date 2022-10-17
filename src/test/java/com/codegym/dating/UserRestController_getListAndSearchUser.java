package com.codegym.dating;

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
public class UserRestController_getListAndSearchUser {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListAndSearchUser_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/admin/list/user?typeUser=&name=&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(4))
                .andExpect(jsonPath("totalElements").value(20))
                .andExpect(jsonPath("content[4].name").value("Phạm Hữu Minh Tâm"))
                .andExpect(jsonPath("content[4].coin").value("1356"))
                .andExpect(jsonPath("content[4].joinDate").value("2020-04-12"))
                .andExpect(jsonPath("content[4].typeUser").value("Basic"))
                .andExpect(jsonPath("content[4].quantity").value("3"));
    }

    @Test
    public void getListAndSearchUser_7() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/admin/list/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListAndSearchUser_8() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/admin/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void getListAndSearchUser_name_7() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/admin/list/user?name=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListAndSearchUser_name_8() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/admin/list/user?name="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListAndSearchUser_name_9() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("api/admin/list/user?name=Tuan"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListAndSearchUser_name_11() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("api/admin/list/user?name=Nhiên"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
