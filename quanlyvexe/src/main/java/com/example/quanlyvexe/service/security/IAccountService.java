package com.example.quanlyvexe.service.security;

import com.example.quanlyvexe.model.Account;

public interface IAccountService {
    Account findUserByEmail(String email);
}
