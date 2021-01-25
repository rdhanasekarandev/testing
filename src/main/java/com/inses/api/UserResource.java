package com.inses.api;

import com.inses.modal.User;
import com.inses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "user")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping("/get")
    private List<User> getAllPost() throws ExecutionException, InterruptedException {
        return userService.getAllUser();
    }
}
