package com.codegym.dating.controller;

import com.codegym.dating.dto.UserDto;
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
public class UserRestController_createUser {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getInfoAccount_id_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/public/account/save/{idAccount}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveUser_name_13() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setGender(true);
        userDto.setDateOfBirth("1999-12-29");
        userDto.setAddress("Quảng Nam");
        userDto.setJob("Lập trình viên");
        userDto.setMarried(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/user/save/{idAccount}","1")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveUser_name_14() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setName("");
        userDto.setGender(true);
        userDto.setDateOfBirth("1999-12-29");
        userDto.setAddress("Quảng Nam");
        userDto.setJob("Lập trình viên");
        userDto.setMarried(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/user/save/{idAccount}","1")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveUser_dateOfBirth_14() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setName("Lê Đức Trọng");
        userDto.setGender(true);
        userDto.setDateOfBirth("");
        userDto.setAddress("Quảng Nam");
        userDto.setJob("Lập trình viên");
        userDto.setMarried(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/user/save/{idAccount}","1")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveUser_dateOfBirth_15() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setName("Lê Đức Trọng");
        userDto.setGender(true);
        userDto.setDateOfBirth("abc");
        userDto.setAddress("Quảng Nam");
        userDto.setJob("Lập trình viên");
        userDto.setMarried(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/user/save/{idAccount}","1")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveUser_gender_13() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setName("Lê Đức Trọng");
        userDto.setDateOfBirth("1999-12-29");
        userDto.setAddress("Quảng Nam");
        userDto.setJob("Lập trình viên");
        userDto.setMarried(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/user/save/{idAccount}","1")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveUser_address_13() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setName("Lê Đức Trọng");
        userDto.setGender(true);
        userDto.setDateOfBirth("1999-12-29");
        userDto.setJob("Lập trình viên");
        userDto.setMarried(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/user/save/{idAccount}","1")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveUser_address_14() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setName("Lê Đức Trọng");
        userDto.setGender(true);
        userDto.setDateOfBirth("1999-12-29");
        userDto.setAddress("");
        userDto.setJob("Lập trình viên");
        userDto.setMarried(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/user/save/{idAccount}","1")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveUser_job_13() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setName("Lê Đức Trọng");
        userDto.setGender(true);
        userDto.setDateOfBirth("1999-12-29");
        userDto.setAddress("Quảng Nam");
        userDto.setMarried(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/user/save/{idAccount}","1")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveUser_job_14() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setName("Lê Đức Trọng");
        userDto.setGender(true);
        userDto.setDateOfBirth("1999-12-29");
        userDto.setAddress("Quảng Nam");
        userDto.setJob("");
        userDto.setMarried(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/user/save/{idAccount}","1")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveUser_married_13() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setName("Lê Đức Trọng");
        userDto.setGender(true);
        userDto.setDateOfBirth("1999-12-29");
        userDto.setAddress("Quảng Nam");
        userDto.setJob("Lập trình viên");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/user/save/{idAccount}","1")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveUser_allItem_18() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setName("Lê Đức Trọng");
        userDto.setGender(true);
        userDto.setDateOfBirth("1999-12-29");
        userDto.setAddress("Quảng Nam");
        userDto.setJob("Lập trình viên");
        userDto.setMarried(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/user/save/{idAccount}","1")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
