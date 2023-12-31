package com.demowebservice.service;

import com.demowebservice.model.Account;
import com.demowebservice.model.Role;
import com.demowebservice.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {
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
        List<Role> roles = new ArrayList<>();
        roles.add(account.getRole());
        User user = new User(account.getUsername(), account.getPassword(), roles);
        return user;
    }
}
