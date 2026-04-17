package com.core.uber.models;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Rider extends User{
    private String phoneNumber;
    private UserType userType;

}
