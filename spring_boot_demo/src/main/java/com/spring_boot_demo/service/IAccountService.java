package com.spring_boot_demo.service;

import com.spring_boot_demo.model.Account;
import com.spring_boot_demo.repository.IAccountRepo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {
    public List<Account> getAll();
    public Account save(Account account);
    public void edit(Account account);
    public void delete(int id);
    public Account findById(int id);
    public List<Account> getAllByName(String name);
    public Account findByUsernamePasswordHQL(String name, String password);
    Account findByUsername(String username);
}
