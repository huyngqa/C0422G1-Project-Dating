package com.codegym.dating.dto;

import com.codegym.dating.model.AccountRole;
import com.codegym.dating.model.User;
import com.codegym.dating.ulti.AccountValidate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto implements Validator {

    private Integer idAccount;

    @Email(message = "vui lòng nhập đúng định dạng !")
    private String email;

    private String phone;

    @Min(value = 6, message = "Mật khẩu yếu !")
    @Max(value = 50, message = "Mật khẩu quá dài !")
    private String password;

    private Integer status;

    private User user;

    private Set<AccountRole> accountRoles;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountDto accountDto = (AccountDto) target;

        AccountValidate.checkEmail(accountDto, errors);

        AccountValidate.checkPhone(accountDto, errors);

        AccountValidate.checkPassword(accountDto, errors);
    }
}
