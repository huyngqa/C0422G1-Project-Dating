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
public class PostRestController_listPost {
    @Autowired
    private MockMvc mockMvc;

     //* Get List with id = null
    @Test
    public void  getListPost_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/post/list/{id}","null"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    //     * Get  List with id = ""
    @Test
    public void  getListPost_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/post/list/{id}",""))
                .andDo(print()).andExpect(status().is4xxClientError());
    }


    //     * Get  List with id not in database
    @Test
    public void  getListPost_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/post/list/{id}","30"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }


    // * Get  List with id  in database but return list size = 0
    @Test
    public void getListPost_10 () throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/post/list/{id}","1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.length()").value(4))
                .andExpect(jsonPath("$.[0].idPost").value(""))
                .andExpect(jsonPath("content").value(""))
                .andExpect(jsonPath("media").value(""))
                .andExpect(jsonPath("time").value(""))
                .andExpect(jsonPath("id_user").value(""));

    }

    // * Get  List with id  in database but return list size > 0
    @Test
    public void getListPost_11 () throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/post/list/{id}","1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.length()").value(4))
                .andExpect(jsonPath("$.[0].idPost").value(1))
                .andExpect(jsonPath("content").value("thai"))
                .andExpect(jsonPath("media").value("sadasdsadsadsfsfsfsdfsdfsf"))
                .andExpect(jsonPath("time").value("2022-12-02 00:00:00.000000"))
                .andExpect(jsonPath("id_user").value(1));

    }






}
