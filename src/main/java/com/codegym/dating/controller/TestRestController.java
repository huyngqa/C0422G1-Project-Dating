package com.codegym.dating.controller;

import com.codegym.dating.model.Account;
import com.codegym.dating.model.AccountRole;
import com.codegym.dating.model.Gift;
import com.codegym.dating.model.composite.AccountRoleKey;
import com.codegym.dating.repository.IAccountRepository;
import com.codegym.dating.repository.IAccountRoleRepository;
import com.codegym.dating.service.IGiftService;
import com.codegym.dating.service.IGiftUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class TestRestController {
    @Autowired
    private IAccountRoleRepository iAccountRoleRepository;
    @Autowired
    private IAccountRepository iAccountRepository;

    @Autowired
    private IGiftService giftService;

    @Autowired
    private IGiftUserService giftUserService;

//    @GetMapping("/test")
//    public ResponseEntity<String> listResponseEntity() {
//        Optional<Account> account = iAccountRepository.findById(1);
//        Optional<AccountRole> accountRole = iAccountRoleRepository.findById(new AccountRoleKey(1, 1));
//        return new ResponseEntity<>(accountRole.get().getAccount().getEmail() + accountRole.get().getRole().getRoleName(), HttpStatus.OK);
//    }

    @GetMapping("/listGift")
    public ResponseEntity<List<Gift>> goListGift() {
        List<Gift> gifts = this.giftService.findAllGift();
        if(gifts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(gifts, HttpStatus.OK);
    }

    @PatchMapping("/saveGiftUser")
    public ResponseEntity<Void> updateGiftUser(@RequestParam Integer idGift, @RequestParam Integer idUserReceiver, @RequestParam Integer idUserSender , @RequestParam Integer quantity) {
      this.giftUserService.updateGiveAGift(idGift, idUserReceiver, idUserSender, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
