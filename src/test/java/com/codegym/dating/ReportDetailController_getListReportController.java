package com.codegym.dating;

import com.codegym.dating.dto.ReportDetailsDto;
import com.codegym.dating.model.ReportDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ReportDetailController_getListReportController {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getListReportDetail_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/report-detail/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getListReportDetail_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/rest/report-detail?page=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(4))
                .andExpect(jsonPath("totalElements").value(12))
                .andExpect(jsonPath("content[0].status").value("8"))
                .andExpect(jsonPath("content[0].timeReport").value("2022-12-22T00:00:00"))
                .andExpect(jsonPath("content[0].reporter").value(9));
    }

}
