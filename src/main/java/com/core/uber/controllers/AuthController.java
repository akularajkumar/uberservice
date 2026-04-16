package com.core.uber.controllers;


import com.core.uber.dtos.riderDto;
import com.core.uber.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    UserService userService;

    @PostMapping("/signup")
    public void SignUp(@RequestBody riderDto riderDto){
        userService.signUp(riderDto);
    }

    @GetMapping("/signin")
    public void SignIn(){

    }

}
