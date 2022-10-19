//package com.codegym.dating.controller;
//
//import com.codegym.dating.dto.AccountDto;
//import com.codegym.dating.dto.UserDto;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class AccountRestController_createAccount {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void saveAccount_email_13() throws Exception {
//
//        AccountDto accountDto = new AccountDto();
//        accountDto.setPhone("0934774152");
//        accountDto.setPassword("123456");
//        accountDto.setStatus(0);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/public/account/save")
//                        .content(this.objectMapper.writeValueAsString(accountDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void saveAccount_email_14() throws Exception {
//
//        AccountDto accountDto = new AccountDto();
//        accountDto.setEmail("");
//        accountDto.setPhone("0934774152");
//        accountDto.setPassword("123456");
//        accountDto.setStatus(0);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/public/account/save")
//                        .content(this.objectMapper.writeValueAsString(accountDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void saveAccount_email_15() throws Exception {
//
//        AccountDto accountDto = new AccountDto();
//        accountDto.setEmail("letrong");
//        accountDto.setPhone("0934774152");
//        accountDto.setPassword("123456");
//        accountDto.setStatus(0);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/public/account/save")
//                        .content(this.objectMapper.writeValueAsString(accountDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void saveAccount_phone_13() throws Exception {
//
//        AccountDto accountDto = new AccountDto();
//        accountDto.setEmail("letrong2929@gmail.com");
//        accountDto.setPassword("123456");
//        accountDto.setStatus(0);
//
//        UserDto userDto = new UserDto();
//        userDto.setIdUser(1);
//        accountDto.setUserDto(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/public/account/save")
//                        .content(this.objectMapper.writeValueAsString(accountDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void saveAccount_phone_14() throws Exception {
//
//        AccountDto accountDto = new AccountDto();
//        accountDto.setEmail("letrong2929@gmail.com");
//        accountDto.setPhone("");
//        accountDto.setPassword("123456");
//        accountDto.setStatus(0);
//
//        UserDto userDto = new UserDto();
//        userDto.setIdUser(1);
//        accountDto.setUserDto(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/public/account/save")
//                        .content(this.objectMapper.writeValueAsString(accountDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void saveAccount_phone_15() throws Exception {
//
//        AccountDto accountDto = new AccountDto();
//        accountDto.setEmail("letrong2929@gmail.com");
//        accountDto.setPhone("0000000");
//        accountDto.setPassword("123456");
//        accountDto.setStatus(0);
//
//        UserDto userDto = new UserDto();
//        userDto.setIdUser(1);
//        accountDto.setUserDto(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/public/account/save")
//                        .content(this.objectMapper.writeValueAsString(accountDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void saveAccount_password_13() throws Exception {
//
//        AccountDto accountDto = new AccountDto();
//        accountDto.setEmail("minhtam@gmail.com");
//        accountDto.setPhone("0934774152");
//        accountDto.setStatus(0);
//
//        UserDto userDto = new UserDto();
//        userDto.setIdUser(1);
//        accountDto.setUserDto(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/public/account/save")
//                        .content(this.objectMapper.writeValueAsString(accountDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void saveAccount_password_14() throws Exception {
//
//        AccountDto accountDto = new AccountDto();
//        accountDto.setEmail("minhtam@gmail.com");
//        accountDto.setPhone("0934774152");
//        accountDto.setPassword("");
//        accountDto.setStatus(0);
//
//        UserDto userDto = new UserDto();
//        userDto.setIdUser(1);
//        accountDto.setUserDto(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/public/account/save")
//                        .content(this.objectMapper.writeValueAsString(accountDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void saveAccount_password_16() throws Exception {
//
//        AccountDto accountDto = new AccountDto();
//        accountDto.setEmail("minhtam@gmail.com");
//        accountDto.setPhone("0934774152");
//        accountDto.setPassword("123");
//        accountDto.setStatus(0);
//
//        UserDto userDto = new UserDto();
//        userDto.setIdUser(1);
//        accountDto.setUserDto(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/public/account/save")
//                        .content(this.objectMapper.writeValueAsString(accountDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void saveAccount_password_15() throws Exception {
//
//        AccountDto accountDto = new AccountDto();
//        accountDto.setEmail("minhtam@gmail.com");
//        accountDto.setPhone("0934774152");
//        accountDto.setPassword("123abcbaskjbjdkjqwkjbnsdskjbnakjbasjkjbndakjbjcsakjnaskjndasjknckjbabskjbckabkjbaskjcbaskjbcqwasdjkjkasaskdjncjknassjkncas");
//        accountDto.setStatus(0);
//
//        UserDto userDto = new UserDto();
//        userDto.setIdUser(1);
//        accountDto.setUserDto(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/public/account/save")
//                        .content(this.objectMapper.writeValueAsString(accountDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void saveAccount_allItem_18() throws Exception {
//
//        AccountDto accountDto = new AccountDto();
//        accountDto.setEmail("minhtam@gmail.com");
//        accountDto.setPhone("0934774152");
//        accountDto.setPassword("123123");
//        accountDto.setStatus(0);
//
//        UserDto userDto = new UserDto();
//        userDto.setIdUser(1);
//        accountDto.setUserDto(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/public/account/save")
//                        .content(this.objectMapper.writeValueAsString(accountDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//}
