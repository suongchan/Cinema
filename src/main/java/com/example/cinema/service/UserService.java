package com.example.cinema.service;

import com.example.cinema.domain.User;
import com.example.cinema.entity.UserEntity;
import com.example.cinema.exception.FieldMissMatchException;

import java.util.List;

public interface UserService {
    Long createUser(User user );
    void register(User user);

     List<UserEntity> getCustomers();
  
    boolean updatePassword(String name, String oldPassword, String newPassword);
}
