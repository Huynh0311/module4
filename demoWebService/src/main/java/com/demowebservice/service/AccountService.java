package com.demowebservice.service;

import com.demowebservice.model.Account;
import com.demowebservice.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
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
}
