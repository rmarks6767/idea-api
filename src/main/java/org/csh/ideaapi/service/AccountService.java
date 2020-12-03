package org.csh.ideaapi.service;

import org.csh.ideaapi.data.dao.AccountRepository;
import org.csh.ideaapi.data.dto.Account;
import org.csh.ideaapi.data.entity.AccountEntity;
import org.csh.ideaapi.data.mapper.AccountMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account createAccount(Account account) {
        AccountMapper mapper = Mappers.getMapper(AccountMapper.class);
        AccountEntity newUser = mapper.accountToAccountDTO(account);

        return mapper.accountDTOtoAccount(accountRepository.save(newUser));
    }

    public Account login(String username, String password) {
        AccountMapper mapper = Mappers.getMapper(AccountMapper.class);

        return mapper.accountDTOtoAccount(accountRepository.findByUsernameAndPassword(username, password));
    }

}
