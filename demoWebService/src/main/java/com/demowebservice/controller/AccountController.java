package com.demowebservice.controller;

import com.demowebservice.model.Account;
import com.demowebservice.service.AccountService;
import com.demowebservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    RoleService roleService;
    @GetMapping
    public List<Account> getAll(){
        return accountService.getAll();
    }
    @PostMapping
    public Account save(@RequestBody Account account){
        return accountService.save(account);
    }
    @GetMapping("/edit/{id}")
    public Account showFormEdit(@PathVariable int id){
        return accountService.findById(id);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        accountService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/search/{name}")
    public List<Account> getAllByName(@PathVariable String name){
        return accountService.getAllByName(name);
    }
}
