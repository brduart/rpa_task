package com.example.demo.dto;

import com.example.demo.entities.RoleName;


public class CreateUserDTO {

    private String name;
    private String password;
    private RoleName role;

    public CreateUserDTO(String name, String password, RoleName role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }
}
