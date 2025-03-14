package com.example.demo.dto;

import com.example.demo.entities.Role;

import java.util.List;

public class RecoveryUserDTO{

        Long id;
        String email;
        List<Role> roles;

    public RecoveryUserDTO(Long id, String email, List<Role> roles) {
        this.id = id;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<Role> getRoles() {
        return roles;
    }
}