package com.codegym.dating.controller;

import com.codegym.dating.DTO.UserReportDto;
import com.codegym.dating.DTO.UserSummaryDto;
import com.codegym.dating.model.User;
import com.codegym.dating.service.IReportDetailsService;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/admin")
public class RestUserFulController {
    @Autowired
    private IUserService iUserService;

    @Autowired
    private IReportDetailsService reportDetailsService;

    @GetMapping(value = "/list/user")
    public ResponseEntity<Page<UserSummaryDto>> findAll(@PageableDefault(page =0,size = 5) Pageable pageable,
                                              @RequestParam Optional<String> name, @RequestParam String typeUser){
        String nameVal = name.orElse("");
        Page<User> userPage;
        if (typeUser == null || typeUser.equals("")) {
            userPage = iUserService.findAll(nameVal,pageable);
        } else {
            String keyWord = nameVal.toLowerCase();
            userPage = iUserService.findByTypeUser(keyWord, typeUser, pageable);
        }
        List<User> userList = userPage.getContent();
        List<Integer> userIds = userList.stream().map(user -> user.getIdUser()).collect(Collectors.toList());
        List<UserReportDto> userReportDtoList = reportDetailsService.findByUserList(userIds);
        Map<Integer, Long> mapUserReport = new HashMap<>();
        for (UserReportDto userReportDto : userReportDtoList) {
            mapUserReport.put(userReportDto.getIdUser(), userReportDto.getCountReport());
        }
        List<UserSummaryDto> userSummaryDtoList = new ArrayList<>();
        for (User user : userList) {
            UserSummaryDto userSummaryDto = new UserSummaryDto(user.getIdUser(),
                    user.getName(),
                    user.getCoin(),
                    user.getJoinDay(),
                    user.getTypeUser().getTypeUserName(),
                    mapUserReport.get(user.getIdUser()) != null ? mapUserReport.get(user.getIdUser()) : 0l );
            userSummaryDtoList.add(userSummaryDto);
        }
        Page<UserSummaryDto> userSummaryDtos = new PageImpl<>(userSummaryDtoList, pageable, userPage.getTotalElements());
        if(userSummaryDtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(userSummaryDtos, HttpStatus.OK);
        }
    }
}
