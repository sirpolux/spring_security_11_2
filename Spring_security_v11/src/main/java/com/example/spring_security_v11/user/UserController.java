package com.example.spring_security_v11.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private  final  IUserServices userServices;

    @GetMapping("all")
    public List<User> getAllUsers(){
        return userServices.getALlUsers();
    }

}
