package com.spring_boot_demo.controller;

import com.spring_boot_demo.model.Account;
import com.spring_boot_demo.service.IAccountService;
import com.spring_boot_demo.service.IRoleService;
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
    IAccountService accountService;
//    @Autowired
//    IRoleService roleService;
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
    @GetMapping("/search")
    public List<Account> getAllByName(String username){
        return accountService.getAllByName(username);
    }

//    @GetMapping("/login")
//    public Account findByUsernamePassWord(@RequestBody Account account){
//        return accountService.findByUsernamePasswordHQL(account.getUsername(), account.getPassword());
//    }
    @GetMapping("/login")
    public Account findByUsernamePassWord(@RequestParam String username,@RequestParam String password){
        return accountService.findByUsernamePasswordHQL(username, password);
    }
}
