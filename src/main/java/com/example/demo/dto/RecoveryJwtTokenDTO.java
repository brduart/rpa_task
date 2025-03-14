package com.example.demo.dto;

public class RecoveryJwtTokenDTO{

        String token;

    public RecoveryJwtTokenDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}