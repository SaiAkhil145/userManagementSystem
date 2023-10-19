package com.geekster.userManagementSystem.Service;

import com.geekster.userManagementSystem.Model.User;
import com.geekster.userManagementSystem.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;

    public String addUser(User newUser) {
        userRepo.save(newUser);
        return "user added";
    }


    public List<User> getUser() {
        return (List<User>) userRepo.findAll();
    }



    public String deleteUser(Long id) {
        userRepo.deleteById(id);
        return "removed";
    }


    public User getUserById(Long id) {
        return userRepo.findById(id).get();
    }

    public String updateUserById(Long id, String number) {
        User newUser = userRepo.findById(id).orElse(null);
        if(newUser!=null){
            newUser.setPhoneNumber(number);
            return "update successfully";
        }
        return "user not found with this "+id;
    }


    public String updateUserById(Long id, String name, String email, String address, String phoneNumber) {
        User user = userRepo.findById(id).orElse(null);
        if(user!=null){
            user.setUserName(name);
            user.setEmail(email);
            user.setAddress(address);
            user.setPhoneNumber(phoneNumber);
            userRepo.save(user);
            return "info updated";
        }
        return "invalid id";
    }
}
