package com.example.cinema.converter;

import com.example.cinema.domain.User;
import com.example.cinema.entity.UserEntity;

public class UserConverter {
    public static UserEntity toEntity(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setDateOfBirth(user.getDateOfBirth());
        userEntity.setPhone(user.getPhone());
        userEntity.setEmail(user.getEmail());
        userEntity.setAddress(user.getAddress());
        userEntity.setRole("ROLE_USER");
        return userEntity;
    }
}
