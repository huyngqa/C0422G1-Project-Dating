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
public class ReportDetailController_getInfoListReport {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getInfoReportDetail_id_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/rest/detail/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoReportDetail_id_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/rest/detail/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("reporter").value(7))
                .andExpect(jsonPath("report").value(1));
    }
}
