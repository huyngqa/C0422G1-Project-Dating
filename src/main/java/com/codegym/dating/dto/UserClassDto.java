package com.codegym.dating.dto;

import com.codegym.dating.model.Account;
import com.codegym.dating.model.StatusActive;
import com.codegym.dating.model.TypeUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserClassDto implements Validator {

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
    private StatusActive statusActive;
    private Account account;
    private TypeUser typeUser;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
