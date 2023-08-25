package com.demowebservice.repository;

import com.demowebservice.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountRepo extends CrudRepository<Account, Integer> {
    @Query(nativeQuery = true, value = "select * from Account where username like concat('%', :name, '%')")
    List<Account> getAllByNameHQL(@Param("name") String name);
}