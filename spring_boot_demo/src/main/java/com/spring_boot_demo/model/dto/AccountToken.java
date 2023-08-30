package com.spring_boot_demo.model.dto;

import com.spring_boot_demo.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountToken {
    private int id;
    private String username;
    private String token;
    private List<Role> roles;
}
