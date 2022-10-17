package com.codegym.dating.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class TestGiveAGiftController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void goListGift_5() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/public/gift/ListGift"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void goListGift_6() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/public/gift/listGift"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void findByIdUser_1() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/public/gift/user/{idUser}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findByIdUser_2() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/public/gift/user/{idUser}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findByIdUser_3() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/public/gift/user/{idUser}", 25))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findByIdUser_4() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/public/gift/user/{idUser}", 20))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("idUser").value(20))
                .andExpect(jsonPath("address").value("37 Yên Thế, Đà Nẵng"))
                .andExpect(jsonPath("avatar").value("chuacoanh"))
                .andExpect(jsonPath("coin").value(2446))
                .andExpect(jsonPath("dateOfBirth").value("1997-04-09"))
                .andExpect(jsonPath("gender").value(true))
                .andExpect(jsonPath("job").value("Giáo Viên Tiếng Anh"))
                .andExpect(jsonPath("joinDay").value("2021-06-28"))
                .andExpect(jsonPath("married").value(false))
                .andExpect(jsonPath("name").value("Nguyễn Hoàng Đa Phúc"))
                .andExpect(jsonPath("typeUser.idTypeUser").value(2));
    }

    /*--------------------------------*/

    @Test
    public void findByIdGift_1() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/public/gift/gift/{idGift}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findByIdGift_2() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/public/gift/gift/{idGift}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findByIdGift_3() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/public/gift/gift/{idGift}", 25))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findByIdGift_4() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/public/gift/gift/{idGift}", 3))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("idGift").value(3))
                .andExpect(jsonPath("giftName").value("Xu"))
                .andExpect(jsonPath("price").value("3000"));
    }


    @Test
    public void updateGiftUser_idGift_19() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/gift/saveGiftUser?idGift=" + null + "&idUserReceiver=1&idUserSender=2&quantity=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateGiftUser_idGift_20() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/gift/saveGiftUser?idGift=" + "&idUserReceiver=1&idUserSender=2&quantity=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateGiftUser_idUserReceiver_19() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/gift/saveGiftUser?idGift=1" + "&idUserReceiver=" + null + "&idUserSender=2&quantity=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateGiftUser_idUserReceiver_20() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/gift/saveGiftUser?idGift=1" + "&idUserReceiver=&idUserSender=2&quantity=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateGiftUser_idUserSender_19() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/gift/saveGiftUser?idGift=1" + "&idUserReceiver=1&idUserSender="+ null +"&quantity=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateGiftUser_idUserSender_20() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/gift/saveGiftUser?idGift=1" + "&idUserReceiver=1&idUserSender=&quantity=1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateGiftUser_quantity_19() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/gift/saveGiftUser?idGift=1" + "&idUserReceiver=1&idUserSender=1&quantity="+ null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateGiftUser_quantity_20() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/gift/saveGiftUser?idGift=1" + "&idUserReceiver=1&idUserSender=1&quantity="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateGiftUser_24() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/gift/saveGiftUser?idGift=1&idUserReceiver=1&idUserSender=1&quantity=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
