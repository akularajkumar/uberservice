package com.core.uber.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String userName;


}
