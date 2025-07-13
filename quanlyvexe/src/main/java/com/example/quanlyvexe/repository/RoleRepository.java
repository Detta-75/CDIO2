package com.example.quanlyvexe.repository;

import com.example.quanlyvexe.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
