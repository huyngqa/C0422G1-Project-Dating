package com.codegym.dating.controller;

import com.codegym.dating.DTO.ListUserDto;
import com.codegym.dating.DTO.ReportDetailDto;
import com.codegym.dating.model.ReportDetails;
import com.codegym.dating.service.IReportDetailsService;
import com.codegym.dating.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/admin")
public class RestFulReportDetailController {
    @Autowired
    private IReportDetailsService iReportDetailsService;

    @GetMapping(value = "/list/warning/{id}")
    public ResponseEntity<?> getUserReportDetail(@PathVariable int id){
        List<ReportDetailDto> reportDetails = iReportDetailsService.findByIdReportDetailUser(id);
        return new ResponseEntity<>(reportDetails, HttpStatus.OK);
    }
}
