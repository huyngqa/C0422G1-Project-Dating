package com.codegym.dating.model;

import com.codegym.dating.model.composite.ReportUserKey;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportUser {
    @EmbeddedId
    private ReportUserKey id;
    @ManyToOne
    @MapsId("idReport")
    @JoinColumn(name = "id_report")
    @JsonBackReference(value = "reportUser_report")
    private Report report;
    @ManyToOne
    @MapsId("idReported")
    @JsonBackReference(value = "reportUser_reported")
    @JoinColumn(name = "id_reported")
    private User reported;
    @ManyToOne
    @MapsId("idReporter")
    @JoinColumn(name = "id_reporter")
    @JsonBackReference(value = "reportUser_reporter")
    private User reporter;
    private Integer status;
    private LocalDateTime timeReport;
}
