package com.example.cinema.service;

import com.example.cinema.domain.User;
import com.example.cinema.exception.FieldMissMatchException;

public interface UserService {
    Long createUser(User user);
    void register(User user) throws FieldMissMatchException;
}
