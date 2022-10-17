package com.codegym.dating.controller;


import com.codegym.dating.dto.ClassUserDto;
import com.codegym.dating.dto.ClassStatusActiveDto;
import com.codegym.dating.dto.ClassTypeUserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRestController_updateAvatar {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateAvatar_id_19() throws Exception {

        ClassUserDto userDto = new ClassUserDto();
        userDto.setName("Nguyễn Trần Thanh Trang");
        userDto.setDateOfBirth(LocalDate.parse("1970-11-07"));
        userDto.setGender(false);
        userDto.setAddress("28 Nguyễn Công Trứ , Phường An Hải Tây,Quận Sơn Trà , Thành Phố Đà Nẵng");
        userDto.setJob("Hướng Dẫn Viên Du Lịch");
        userDto.setMarried(false);
        userDto.setAvatar("image.png");
        userDto.setJoinDay(LocalDate.parse("2021-01-01"));
        userDto.setCoin(1000);

        ClassStatusActiveDto statusActiveDto = new ClassStatusActiveDto();
        statusActiveDto.setId(1);
        userDto.setStatusActiveDto(statusActiveDto);

        ClassTypeUserDto typeUserDto = new ClassTypeUserDto();
        typeUserDto.setIdTypeUser(1);
        userDto.setTypeUserDto(typeUserDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/users/update_avatar/{id}", "null")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateAvatar_id_20() throws Exception {

        ClassUserDto userDto = new ClassUserDto();
        userDto.setName("Nguyễn Trần Thanh Trang");
        userDto.setDateOfBirth(LocalDate.parse("1970-11-07"));
        userDto.setGender(false);
        userDto.setAddress("28 Nguyễn Công Trứ , Phường An Hải Tây,Quận Sơn Trà , Thành Phố Đà Nẵng");
        userDto.setJob("Hướng Dẫn Viên Du Lịch");
        userDto.setMarried(false);
        userDto.setAvatar("image.png");
        userDto.setJoinDay(LocalDate.parse("2021-01-01"));
        userDto.setCoin(1000);

        ClassStatusActiveDto statusActiveDto = new ClassStatusActiveDto();
        statusActiveDto.setId(1);
        userDto.setStatusActiveDto(statusActiveDto);

        ClassTypeUserDto typeUserDto = new ClassTypeUserDto();
        typeUserDto.setIdTypeUser(1);
        userDto.setTypeUserDto(typeUserDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/users/update_avatar/{id}", "")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateAvatar_id_24() throws Exception {

        ClassUserDto userDto = new ClassUserDto();
        userDto.setName("Nguyễn Trần Thanh Trang");
        userDto.setDateOfBirth(LocalDate.parse("1970-11-07"));
        userDto.setGender(false);
        userDto.setAddress("28 Nguyễn Công Trứ , Phường An Hải Tây,Quận Sơn Trà , Thành Phố Đà Nẵng");
        userDto.setJob("Hướng Dẫn Viên Du Lịch");
        userDto.setMarried(false);
        userDto.setAvatar("image.png");
        userDto.setJoinDay(LocalDate.parse("2021-01-01"));
        userDto.setCoin(1000);

        ClassStatusActiveDto statusActiveDto = new ClassStatusActiveDto();
        statusActiveDto.setId(1);
        userDto.setStatusActiveDto(statusActiveDto);

        ClassTypeUserDto typeUserDto = new ClassTypeUserDto();
        typeUserDto.setIdTypeUser(1);
        userDto.setTypeUserDto(typeUserDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/users/update_avatar/{id}", "1")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
