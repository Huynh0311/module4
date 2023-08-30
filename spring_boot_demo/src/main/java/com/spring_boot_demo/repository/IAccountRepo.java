package com.spring_boot_demo.repository;

import com.spring_boot_demo.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountRepo extends CrudRepository<Account, Integer> {
    List<Account> findAllByUsernameContaining(String username);
    @Query(value = "select a from Account a where a.username like concat('%', :name, '%') ")
    List<Account> findAllByUsernameHQL(@Param("name") String username);
    Account findByUsername(String username);
    @Query(value = "select a from Account a where a.username = :name and a.password = :password")
    Account findByUsernamePasswordHQL(@Param("name") String name,@Param("password") String password);
    @Query(nativeQuery = true, value = "select * from Account where username like concat('%', :name, '%')")
    List<Account> getAllByNameHQL(@Param("name") String name);
}
