package com.codegym.dating;

import com.codegym.dating.dto.StatusActiveDto;
import com.codegym.dating.dto.TypeUserDto;
import com.codegym.dating.dto.UserDto;
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
public class UserRestController_updateStatusActive {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateStatusActive_id_19() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setName("Nguyễn Trần Thanh Trang");
        userDto.setDateOfBirth(LocalDate.parse("1970-11-07"));
        userDto.setGender(false);
        userDto.setAddress("28 Nguyễn Công Trứ , Phường An Hải Tây,Quận Sơn Trà , Thành Phố Đà Nẵng");
        userDto.setJob("Hướng Dẫn Viên Du Lịch");
        userDto.setMarried(false);
        userDto.setAvatar("image.png");
        userDto.setJoinDay(LocalDate.parse("2021-01-01"));
        userDto.setCoin(1000);

        StatusActiveDto statusActiveDto = new StatusActiveDto();
        statusActiveDto.setId(1);
        userDto.setStatusActiveDto(statusActiveDto);

        TypeUserDto typeUserDto = new TypeUserDto();
        typeUserDto.setIdTypeUser(1);
        userDto.setTypeUserDto(typeUserDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/user/update_avatar/{id}","null")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateStatusActive_id_20() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setName("Nguyễn Trần Thanh Trang");
        userDto.setDateOfBirth(LocalDate.parse("1970-11-07"));
        userDto.setGender(false);
        userDto.setAddress("28 Nguyễn Công Trứ , Phường An Hải Tây,Quận Sơn Trà , Thành Phố Đà Nẵng");
        userDto.setJob("Hướng Dẫn Viên Du Lịch");
        userDto.setMarried(false);
        userDto.setAvatar("image.png");
        userDto.setJoinDay(LocalDate.parse("2021-01-01"));
        userDto.setCoin(1000);

        StatusActiveDto statusActiveDto = new StatusActiveDto();
        statusActiveDto.setId(1);
        userDto.setStatusActiveDto(statusActiveDto);

        TypeUserDto typeUserDto = new TypeUserDto();
        typeUserDto.setIdTypeUser(1);
        userDto.setTypeUserDto(typeUserDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/user/update_avatar/{id}","")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateStatusActive_id_24() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setName("Nguyễn Trần Thanh Trang");
        userDto.setDateOfBirth(LocalDate.parse("1970-11-07"));
        userDto.setGender(false);
        userDto.setAddress("28 Nguyễn Công Trứ , Phường An Hải Tây,Quận Sơn Trà , Thành Phố Đà Nẵng");
        userDto.setJob("Hướng Dẫn Viên Du Lịch");
        userDto.setMarried(false);
        userDto.setAvatar("image.png");
        userDto.setJoinDay(LocalDate.parse("2021-01-01"));
        userDto.setCoin(1000);

        StatusActiveDto statusActiveDto = new StatusActiveDto();
        statusActiveDto.setId(1);
        userDto.setStatusActiveDto(statusActiveDto);

        TypeUserDto typeUserDto = new TypeUserDto();
        typeUserDto.setIdTypeUser(1);
        userDto.setTypeUserDto(typeUserDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/user/update_avatar/{id}","1")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
