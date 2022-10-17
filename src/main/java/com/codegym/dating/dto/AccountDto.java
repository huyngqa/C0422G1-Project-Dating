package com.codegym.dating.dto;

import com.codegym.dating.model.AccountRole;
import com.codegym.dating.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Integer idAccount;

    private String email;

    private String phone;

    @NotBlank(message = "Vui lòng không được để trống trường này")
    private String password;

    private Integer status;

    private User user;

    private Set<AccountRole> accountRoles;

}
