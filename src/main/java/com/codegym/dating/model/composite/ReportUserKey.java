package com.codegym.dating.model.composite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ReportUserKey implements Serializable {
    @Column(name = "id_report")
    private Integer idReport;
    @Column(name = "id_reported")
    private Integer idReported;
    @Column(name = "id_reporter")
    private Integer idReporter;
}
