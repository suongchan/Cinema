package com.example.cinema.service;

import com.example.cinema.domain.User;
import com.example.cinema.exception.FieldMissMatchException;


import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

public interface UserService {

    Long createUser(User user);
    void register(User user) throws FieldMissMatchException;


    boolean updatePassword(String name, String oldPassword, String newPassword);

    UserEntity getUserById(Long id);
     void deleteUser(Long id) throws UserPrincipalNotFoundException;
     void updateUser(User user) throws UserPrincipalNotFoundException;
}
