package com.example.cinema.service.impl;

import com.example.cinema.converter.UserConverter;
import com.example.cinema.domain.User;
import com.example.cinema.entity.UserEntity;
import com.example.cinema.exception.FieldMissMatchException;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.service.UserService;
import com.example.cinema.validator.UserRegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRegisterValidator validator;

    @Transactional
    @Override
    public void register(User user) throws FieldMissMatchException {
        validator.validateRegisterUser(user);
        UserEntity entity = UserConverter.toEntity(user);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        userRepository.save(entity);
    }

    @Override
    public Long createUser(User user) {
        return userRepository.save(UserConverter.toEntity(user)).getId();
    }
}
