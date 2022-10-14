package com.codegym.dating.controller;

<<<<<<< HEAD
import com.codegym.dating.dto.PostDto;
import com.codegym.dating.model.Account;
import com.codegym.dating.model.AccountRole;
import com.codegym.dating.model.composite.AccountRoleKey;
=======
>>>>>>> 867f5fee73442869452d1acf9c01a1c5f8e40d61
import com.codegym.dating.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class TestRestController {
    @Autowired
    private IAccountRepository iAccountRepository;


    @GetMapping("/test")
    public ResponseEntity<String> listResponseEntity() {
        return new ResponseEntity<>(iAccountRepository.findById(7).get().getEmail(), HttpStatus.OK);
    }

}
