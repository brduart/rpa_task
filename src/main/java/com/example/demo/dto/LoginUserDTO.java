package com.example.demo.dto;

public class LoginUserDTO {

        String name;
        String password;

    public LoginUserDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}