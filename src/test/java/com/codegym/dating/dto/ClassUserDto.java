package com.codegym.dating.dto;

import com.codegym.dating.model.Account;

import java.time.LocalDate;

public class ClassUserDto {

    private Integer idUser;
    private String name;
    private LocalDate dateOfBirth;
    private Boolean gender;
    private String address;
    private String job;
    private Boolean married;
    private String avatar;
    private LocalDate joinDay;
    private Integer coin;
    private ClassStatusActiveDto statusActiveDto;
    private Account account;
    private ClassTypeUserDto typeUserDto;

    public ClassUserDto() {
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDate getJoinDay() {
        return joinDay;
    }

    public void setJoinDay(LocalDate joinDay) {
        this.joinDay = joinDay;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public ClassStatusActiveDto getStatusActiveDto() {
        return statusActiveDto;
    }

    public void setStatusActiveDto(ClassStatusActiveDto statusActiveDto) {
        this.statusActiveDto = statusActiveDto;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ClassTypeUserDto getTypeUserDto() {
        return typeUserDto;
    }

    public void setTypeUserDto(ClassTypeUserDto typeUserDto) {
        this.typeUserDto = typeUserDto;
    }
}
