package com.news.service.impl;

import com.news.model.User;
import com.news.repository.IUserRepo;
import com.news.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    IUserRepo iUserRepo;
    public User login(String username, String password){
        return iUserRepo.login(username, password);
    }
}
