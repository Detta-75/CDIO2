package com.example.quanlyvexe.repository;

import com.example.quanlyvexe.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByEmail(String email);
}
