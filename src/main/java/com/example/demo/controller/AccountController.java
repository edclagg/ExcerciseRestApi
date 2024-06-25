package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@Tag(name = "Account Management", description = "APIs for managing accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    @Operation(summary = "Get list of Accounts")
    public List<Account> getAllAccounts() {

        return accountService.getAllAccounts();
    }

    @GetMapping("/{accountId}")
    @Operation(summary = "Get details of an Account by ID")
    public Account getAccountById(@PathVariable Long accountId) {

        return accountService.getAccountById(accountId);
    }

    @PostMapping
    @Operation(summary = "Add an Account")
    public Account addAccount(@RequestBody Account account) {

        return accountService.addAccount(account);
    }

    @DeleteMapping("/{accountId}")
    @Operation(summary = "Delete an account")
    public void deleteAccount(@PathVariable Long accountId) {

        accountService.deleteAccount(accountId);
    }
}
