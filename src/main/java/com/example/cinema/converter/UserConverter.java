package com.example.cinema.converter;

import com.example.cinema.domain.User;
import com.example.cinema.entity.UserEntity;

public class UserConverter {
    public static UserEntity toEntity(User user){
        UserEntity entity = new UserEntity();
            entity.setUsername(user.getUsername());
            entity.setPassword(user.getPassword());
            entity.setAge(user.getAge());
            entity.setPhone(user.getPhone());
            entity.setEmail(user.getEmail());
            entity.setAddress(user.getAddress());
            entity.setRole("ROLE_USER");
        return entity;
    }
}
