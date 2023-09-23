package com.example.cinema.service;

import com.example.cinema.domain.User;
import com.example.cinema.exception.FieldMissMatchException;

public interface UserService {
    void register(User user) throws FieldMissMatchException;
    Long createUser(User user);
    void register(User user) throws FieldMissMatchException;

    boolean updatePassword(String name, String oldPassword, String newPassword);
}
