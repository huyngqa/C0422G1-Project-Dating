package com.codegym.dating.controller;

import com.codegym.dating.dto.InvoiceDto;
import com.codegym.dating.model.User;
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
public class UpgradeAccountRestController_savePaypal {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void savePaypal_price_13() throws Exception {

        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setPrice(null);

        User user = new User();
        user.setIdUser(2);
        invoiceDto.setUser(user);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/users/upgradeAccount/save")
                        .content(this.objectMapper.writeValueAsString(invoiceDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void savePaypal_price_14() throws Exception {

        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setPrice("");

        User user = new User();
        user.setIdUser(9);
        invoiceDto.setUser(user);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/users/upgradeAccount/save")
                        .content(this.objectMapper.writeValueAsString(invoiceDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void savePaypal_price_15() throws Exception {

        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setPrice("abc");

        User user = new User();
        user.setIdUser(9);
        invoiceDto.setUser(user);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/users/upgradeAccount/save")
                        .content(this.objectMapper.writeValueAsString(invoiceDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void savePaypal_price_18() throws Exception {

        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setPrice("123");

        User user = new User();
        user.setIdUser(9);
        invoiceDto.setUser(user);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/users/upgradeAccount/save")
                        .content(this.objectMapper.writeValueAsString(invoiceDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
