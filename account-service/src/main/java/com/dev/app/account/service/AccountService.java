package com.dev.app.account.service;

import com.dev.app.account.domain.Account;
import com.dev.app.account.repository.AccountRepository;
import com.dev.app.common.resources.dto.AccountDto;
import com.dev.app.common.resources.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper accountMapper;

    @Transactional(readOnly = true)
    public AccountDto findById(Long id){
        return convertToDto(accountRepository.findById(id).orElse(null));
    }

    private AccountDto convertToDto(Account account) {
        accountMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return accountMapper.map(account, AccountDto.class);
    }

    private Account convertToEntity(AccountDto accountDto) {
        Account account = accountMapper.map(accountDto, Account.class);

        if (accountDto.getId() != null) {
            Account oldAcct = accountRepository.findById(accountDto.getId()).get();
            account.setId(oldAcct.getId());
            //add setters here
        }
        return account;
    }


}
