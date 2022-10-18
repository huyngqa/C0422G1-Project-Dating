package com.codegym.dating.controller;

import com.codegym.dating.model.Gift;
import com.codegym.dating.model.User;
import com.codegym.dating.service.IGiftService;
import com.codegym.dating.service.IGiftUserService;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/public/gift")
public class GiveAGiftRestController {

    @Autowired
    private IGiftService giftService;

    @Autowired
    private IGiftUserService giftUserService;

    @Autowired
    private IUserService userService;

    /*List Gift*/
    @GetMapping("/listGift")
    public ResponseEntity<List<Gift>> goListGift() {
        List<Gift> gifts = this.giftService.findAllGift();
        if (gifts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(gifts, HttpStatus.OK);
    }

    /*Tìm kiếm 1 User theo Id*/
    @GetMapping("/user/{idUser}")
    public ResponseEntity<User> findByIdUser(@PathVariable Integer idUser) {
        Optional<User> user = this.userService.findById(idUser);

        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user.orElse(null), HttpStatus.OK);
    }

    /*Tìm kiếm quà tặng theo Id*/
    @GetMapping("/gift/{idGift}")
    public ResponseEntity<Gift> findByIdGift(@PathVariable Integer idGift) {
        Optional<Gift> gift = this.giftService.findById(idGift);

        if (!gift.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(gift.orElse(null), HttpStatus.OK);
    }

    /*Method tặng quà cho user*/
    @PatchMapping("/saveGiftUser")
    public ResponseEntity<Void> updateGiftUser(@RequestParam Integer idGift, @RequestParam Integer idUserReceiver,
                                               @RequestParam Integer idUserSender, @RequestParam Integer quantity) {
        this.giftUserService.updateGiveAGift(idGift, idUserReceiver, idUserSender, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}