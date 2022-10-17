package com.codegym.dating.controller;

import com.codegym.dating.model.Account;
import com.codegym.dating.model.AccountRole;
import com.codegym.dating.model.User;
import com.codegym.dating.model.composite.AccountRoleKey;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ChangePasswordRestController {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void resetPassword_password_19() throws Exception {
        Account account = new Account();
        account.getPassword();
        account.setPassword("");

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/rest/checkPassword")
                .content(this.objectMapper.writeValueAsString(account))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void resetPassword_20() throws Exception {
        Account account = new Account();
        account.getPassword();
        account.setPassword("123123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/rest/checkPassword")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
