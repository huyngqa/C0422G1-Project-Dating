//package com.codegym.dating.controller;
//
//import com.codegym.dating.dto.ReportDetailsDto;
//import com.codegym.dating.dto.ReportDto;
//import com.codegym.dating.model.Report;
//import com.codegym.dating.model.ReportDetails;
//import com.codegym.dating.service.IReportService;
//import com.codegym.dating.service.IReportDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@RestController
//@RequestMapping("/rest")
//public class ReportController {
//    @Autowired
//    private IReportService reportService;
//    @Autowired
//    private IReportDetailsService reportDetailsService;
//
//    @GetMapping("/report-list")
//    public ResponseEntity<List<ReportDto>> getAllReport() {
//        List<ReportDto> reportList = reportService.findAllReport();
//        return new ResponseEntity<>(reportList, HttpStatus.OK);
//    }
//
//
//        @GetMapping("/report-detail")
//    public ResponseEntity<Page<ReportDetails>> getAllReportUser(@PageableDefault(3) Pageable pageable) {
//        Page<ReportDetails> stationPage = reportDetailsService.findAll(pageable);
//        if (!stationPage.hasContent()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(stationPage, HttpStatus.OK);
//    }
//
//    @PatchMapping("/confirm/{id}")
//    public ResponseEntity<Void> confirm(@PathVariable("id") Integer id, @RequestBody ReportDetails reportDetails) {
//        reportDetailsService.confirm(reportDetails);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PostMapping("/report")
//    public ResponseEntity<Void> add(@RequestBody ReportDetails reportDetails) {
//        reportDetailsService.save(reportDetails);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
