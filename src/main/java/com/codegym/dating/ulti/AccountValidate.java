package com.codegym.dating.ulti;

import com.codegym.dating.dto.AccountDto;
import org.springframework.validation.Errors;

public class AccountValidate {

    static public void checkEmail(AccountDto accountDto, Errors errors){

        if (accountDto.getEmail().isEmpty()){
            errors.rejectValue("email",
                    "create.email",
                    "vui lòng nhập email !");
        }
    }

    static public void checkPassword(AccountDto accountDto, Errors errors){

        if (accountDto.getPassword().isEmpty()){
            errors.rejectValue("password",
                    "create.password",
                    "vui lòng nhập mật khẩu !");
        }
    }

    static public void checkPhone(AccountDto accountDto, Errors errors){

        if (!accountDto.getPhone().isEmpty()){
            if (!accountDto.getPhone().matches("^(090|093|097)\\d{7}$")){
                errors.rejectValue("phone",
                        "create.phone",
                        "vui lòng nhập đúng định dạng !");
            }
        }else {
            errors.rejectValue("phone",
                    "create.phone",
                    "vui lòng nhập số điện thoại !");
        }
    }
}
