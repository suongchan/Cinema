package com.example.cinema.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String username;

    private Integer age;
    private String phone;
    private String email;
    private String address;
}
