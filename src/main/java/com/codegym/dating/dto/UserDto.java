package com.codegym.dating.dto;

import java.time.LocalDate;

public interface UserDto {
    Integer getIdUser();

    LocalDate getDateOfBirth();

    String getName();

    String getAddress();

    String getJob();

    String getAvatar();

    Integer getCoin();

    LocalDate getJoinDay();

    String getTypeUserName();

    Boolean getIsMarried();

    Boolean getIsGender();

    String getHobbitName();
}
