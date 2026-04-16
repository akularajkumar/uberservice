package com.core.uber.controllers;


import com.core.uber.dtos.otpRequest;
import com.core.uber.dtos.riderDto;
import com.core.uber.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public String SignUp(@RequestBody riderDto riderDto){
      String val =   userService.signUp(riderDto);
        return val;
    }

    @GetMapping("/signin")
    public void SignIn(){

    }

    @PostMapping("/otp")
    public void otpRequest(@RequestBody otpRequest otpRequest){
        userService.otpRequest(otpRequest.getPhoneNumber());
    }



}
