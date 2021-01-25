package com.inses.api;

import com.inses.modal.User;
import com.inses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "user")
public class UserResource {
    @Autowired
    private UserService userService;

    //  create new User
    @PostMapping("/get")
    public String saveUserDetails(){
        User user = new User();
        user.setName("test");
        user.setEmailId("test@gmail.com");
        user.setPhoneNumber("8056384773");
        return userService.createUser(user);
    }

    //  get all users
    @GetMapping("/get")
    private List<User> getAllPost() throws ExecutionException, InterruptedException {
        return userService.getAllUser();
    }
}
