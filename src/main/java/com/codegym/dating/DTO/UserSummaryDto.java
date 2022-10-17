package com.codegym.dating.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserSummaryDto {
    private Integer idUser;
    private String name;
    private Integer coin;
    private LocalDate joinDate;
    private String typeUser;
    private long quantity;
}
