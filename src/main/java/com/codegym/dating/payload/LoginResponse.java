package com.codegym.dating.payload;

import com.codegym.dating.model.Account;
import com.codegym.dating.model.Role;
import com.codegym.dating.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private Integer idAccount;
    private List<String> roles;

    public LoginResponse(String accessToken, Integer idAccount, List<String> roles) {
        this.accessToken = accessToken;
        this.idAccount = idAccount;
        this.roles = roles;
    }
}
