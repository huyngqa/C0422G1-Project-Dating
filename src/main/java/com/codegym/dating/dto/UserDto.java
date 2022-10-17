package com.codegym.dating.dto;

import java.time.LocalDate;

public interface UserDto {
    Integer getIdUser();

    String getAddress();

    String getAvatar();

    Integer getCoin();

    LocalDate getDateOfBirth();

    Boolean getGender();

    String getJob();

    LocalDate getJoinDay();

    String getName();

    Boolean getMarried();

    Integer idStatusActive();

    Integer getIdTypeUser();

}
