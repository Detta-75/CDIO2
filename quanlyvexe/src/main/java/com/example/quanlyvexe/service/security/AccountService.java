package com.example.quanlyvexe.service.security;

import com.example.quanlyvexe.model.Account;
import com.example.quanlyvexe.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService implements IAccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Account findUserByEmail(String email) {
        return accountRepository.findByEmail(email);
    }
}
