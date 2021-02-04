package com.dev.app.account.controller;

import com.dev.app.account.service.AccountService;
import com.dev.app.common.resources.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.dev.app.common.resources.util.Web.API;
/**
 * @author Aaron MAJAMBO
 * Created by Aaron on 02/04/2021.
 */

@RequiredArgsConstructor
@RestController
@RequestMapping(value = API+"/accounts")
public class AcountController {

    private  final AccountService accountService;

    @GetMapping(value = "/{id}")
    public AccountDto findById(Long id){
        return accountService.findById(id);
    }
}
