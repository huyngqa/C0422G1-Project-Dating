package com.codegym.dating.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReportDetailDto {
    private int idUser;
    private LocalDateTime timeReport;
    private String nameReport;
    private String username;
}
