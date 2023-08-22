package com.news.service;

import com.news.model.User;

public interface IUserService {
    User login(String username, String password);
}
