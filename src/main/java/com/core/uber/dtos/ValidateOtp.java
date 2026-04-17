package com.core.uber.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateOtp {
    private String phoneNumber;
    private String otp;
}
