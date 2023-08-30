package com.spring_boot_demo.service.impl;

import com.spring_boot_demo.model.Account;
import com.spring_boot_demo.repository.IAccountRepo;
import com.spring_boot_demo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepo accountRepo;
    public List<Account> getAll(){
        return (List<Account>) accountRepo.findAll();
    }
    public Account save(Account account){
        return accountRepo.save(account);
    }
    public void edit(Account account){
        accountRepo.save(account);
    }
    public void delete(int id){
        accountRepo.deleteById(id);
    }
    public Account findById(int id){
        return accountRepo.findById(id).get();
    }
    public List<Account> getAllByName(String name){
        return accountRepo.getAllByNameHQL(name);
    }
    public Account findByUsernamePasswordHQL(String name, String password){
        return accountRepo.findByUsernamePasswordHQL(name, password);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findByUsername(username);
        return new User(account.getUsername(), account.getPassword(), account.getRoles());
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepo.findByUsername(username);
    }
}
