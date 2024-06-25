package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.Account;
import com.example.demo.service.UserService;
import com.example.demo.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "User Management", description = "APIs for managing users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @GetMapping
    @Operation(summary = "Get all users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new user")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/{userId}/accounts")
    @Operation(summary = "Add account to a user")
    public User addAccountToUser(@PathVariable Long userId, @RequestBody Account account) {
        User user = userService.getUserById(userId);
        if (user != null) {
            user.getAccountsList().add(accountService.addAccount(account));
            userService.addUser(user);
        }
        return user;
    }

    @DeleteMapping("/{userId}/accounts/{accountId}")
    @Operation(summary = "Delete an account from user")
    public User deleteAccountFromUser(@PathVariable Long userId, @PathVariable Long accountId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            user.getAccountsList().removeIf(account -> account.getAccountId().equals(accountId));
            userService.addUser(user);
        }
        accountService.deleteAccount(accountId);
        return user;
    }
}
