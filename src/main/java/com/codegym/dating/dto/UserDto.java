package com.codegym.dating.dto;

import com.codegym.dating.model.*;
import com.codegym.dating.ulti.UserValidate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Validator {

    private Integer idUser;

    private String name;

    private String dateOfBirth;

    private Boolean gender;

    private String address;

    private String job;

    private Boolean married;

    private String avatar;

    private String joinDay;

    private Integer coin;

    private Integer statusActive;

    private Account account;

    private TypeUser typeUser;

    private List<UserHobbit> userHobbits;

    private List<Post> postList;

    private List<Comment> comments;

    private List<Invoice> invoices;

    private List<UserTarget> userTargets;

    private List<GiftUser> giftSenders;

    private List<GiftUser> giftReceiver;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        UserValidate.checkName(userDto, errors);

        UserValidate.checkGender(userDto, errors);

        UserValidate.checkAge(userDto, errors);

        UserValidate.checkJob(userDto, errors);

        UserValidate.checkJob(userDto, errors);

        UserValidate.checkAddress(userDto, errors);

        UserValidate.checkMarried(userDto, errors);

        UserValidate.checkHobbit(userDto, errors);

        UserValidate.checkTarget(userDto, errors);
    }
}
