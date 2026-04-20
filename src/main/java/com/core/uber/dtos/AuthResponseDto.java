package com.core.uber.dtos;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthResponseDto {
    private String token;

    public AuthResponseDto(String token) {
        this.token = token;
    }

}
