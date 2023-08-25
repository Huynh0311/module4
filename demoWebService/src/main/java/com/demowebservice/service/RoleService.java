package com.demowebservice.service;

import com.demowebservice.model.Role;
import com.demowebservice.repository.IRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    IRoleRepo roleRepo;
    public Role findById(int id){
        return roleRepo.findById(id).get();
    }
}
