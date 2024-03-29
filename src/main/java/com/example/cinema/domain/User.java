package com.example.cinema.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String username;
    private String password;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date dateOfBirth;
    private String phone;
    private String email;
    private String address;
}
