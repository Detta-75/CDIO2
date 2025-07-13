package com.example.quanlyvexe.controller.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPasswordUtils {
    public static String EncryptPasswordUtils(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static Boolean ParseEncrypt(String password, String encodedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, encodedPassword);
    }
}
