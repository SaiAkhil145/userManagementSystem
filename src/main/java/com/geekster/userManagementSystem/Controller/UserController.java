package com.geekster.userManagementSystem.Controller;

import com.geekster.userManagementSystem.Model.User;
import com.geekster.userManagementSystem.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("user")
    public String addUser( @RequestBody User newUser){
        return userService.addUser(newUser);
    }
    @GetMapping("users")
    public List<User> getUser(){
        return userService.getUser();
    }

    @DeleteMapping("user/{id}/id")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
    @GetMapping("user/{id}/id")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("update/{id}/info")
    public String updateUserById(@PathVariable Long id,@RequestParam String name,@RequestParam String email,@RequestParam String address,@RequestParam String phoneNumber){
        return userService.updateUserById(id,name,email,address,phoneNumber);
    }
}
