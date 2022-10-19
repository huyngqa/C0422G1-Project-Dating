package com.codegym.dating.controller;

import com.codegym.dating.dto.ReportDetailsDto;
import com.codegym.dating.dto.ReportDto;
import com.codegym.dating.model.ReportDetails;
import com.codegym.dating.service.IReportService;
import com.codegym.dating.service.IReportDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class ReportController {
    @Autowired
    private IReportService reportService;
    @Autowired
    private IReportDetailsService reportDetailsService;

    @GetMapping("/report-list")
    public ResponseEntity<List<ReportDto>> getAllReport() {
        List<ReportDto> reportList = reportService.findAllReport();
        return new ResponseEntity<>(reportList, HttpStatus.OK);
    }


        @GetMapping("/report-detail")
    public ResponseEntity<Page<ReportDetailsDto>> getAllReportUser(@PageableDefault(3) Pageable pageable,
                                                                   @RequestParam Optional<String> keyWord) {
            String key = keyWord.orElse("");
            Page<ReportDetailsDto> reportDetailsPage = reportDetailsService.findAll(key, pageable);
            if (reportDetailsPage.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else {
                return new ResponseEntity<>(reportDetailsPage, HttpStatus.OK);
            }
    }

    @PatchMapping("/confirm/{id}")
    public ResponseEntity<Void> confirm(@PathVariable("id") Integer id) {
        this.reportDetailsService.confirm(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/report")
    public ResponseEntity<Void> add(@RequestBody ReportDetails reportDetails) {
        this.reportDetailsService.save(reportDetails);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        this.reportDetailsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<ReportDetails> getInfoReport(@PathVariable Integer id) {

        ReportDetails reportDetailsObj = this.reportDetailsService.findById(id);

        if (reportDetailsObj == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(reportDetailsObj, HttpStatus.OK);
    }

}
