package com.news.repository;

import com.news.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IUserRepo extends CrudRepository<User, Integer> {
    @Query(nativeQuery = true, value = "select * from user where username=:username and password=:password")
    User login(@Param("username")String username, @Param("password")String password);
}
