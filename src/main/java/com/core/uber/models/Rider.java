package com.core.uber.models;


import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Rider extends User{

    private UserType userType;

}
