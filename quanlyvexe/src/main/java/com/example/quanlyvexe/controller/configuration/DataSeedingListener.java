package com.example.quanlyvexe.controller.configuration;


import com.example.quanlyvexe.model.Account;
import com.example.quanlyvexe.model.Role;
import com.example.quanlyvexe.repository.AccountRepository;
import com.example.quanlyvexe.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

        if (roleRepository.findByName("ROLE_USER") == null) {
            roleRepository.save(new Role("ROLE_USER"));
        }

        if (accountRepository.findByEmail("admin@gmail.com") == null) {
            Account admin = new Account();
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("123456"));
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findByName("ROLE_ADMIN"));
            roles.add(roleRepository.findByName("ROLE_USER"));
            admin.setRoles(roles);
            accountRepository.save(admin);
        }

        if (accountRepository.findByEmail("member@gmail.com") == null) {
            Account user = new Account();
            user.setEmail("member@gmail.com");
            user.setPassword(passwordEncoder.encode("123456"));
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findByName("ROLE_USER"));
            user.setRoles(roles);
            accountRepository.save(user);
        }
    }
    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}