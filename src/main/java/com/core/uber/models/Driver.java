package com.core.uber.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Driver extends User{

    private UserType userType;
}
