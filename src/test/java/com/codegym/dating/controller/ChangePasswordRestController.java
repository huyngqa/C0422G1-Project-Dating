package com.codegym.dating.controller;

import com.codegym.dating.model.Account;
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
public class ChangePasswordRestController {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /*Check pass - null*/
    @Test
    public void resetPassword_password_19() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("/rest/checkPassword/" + null + "/trung123"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*Check pass - rỗng*/
    @Test
    public void resetPassword_password_20() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/checkPassword/"+ "/trung123"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*Check pass - không tồn tại*/
    @Test
    public void resetPassword_password_21() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/checkPassword/gfhgghg"+ "/trung123"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*Check pass - tồn tại trong db*/
    @Test
    public void resetPassword_password_24() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/checkPassword/abc123" + "/trung123"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //----check new password---

    /*Check new pass - null*/
    @Test
    public void resetPassword_newPassword_19() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("/rest/checkPassword/abc123" + null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*Check new pass - rỗng*/
    @Test
    public void resetPassword_newPassword_20() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/checkPassword/abc123" + "/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*Check new pass - hợp lệ*/
    @Test
    public void resetPassword_newPassword_24() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/rest/checkPassword/abc123"+ "/dinhtrung123"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}
