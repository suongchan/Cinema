package com.example.cinema.service.impl;

import com.example.cinema.converter.UserConverter;
import com.example.cinema.domain.User;
import com.example.cinema.entity.UserEntity;
import com.example.cinema.exception.FieldMissMatchException;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.security.UserPrincipal;
import com.example.cinema.service.UserService;
import com.example.cinema.validator.UserRegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    private UserDetailsService userDetailsService;

    @Override
    public Long createUser(User user) {
        return userRepository.save(UserConverter.toEntity(user)).getId();
    }

    @Transactional
    @Override
    public void register(User user){
        userRepository.save(UserConverter.toEntity(user));
    }

    @Override
    public boolean updatePassword(String username, String oldPassword, String newPassword) {
        UserPrincipal userPrincipal = (UserPrincipal) userDetailsService.loadUserByUsername(username);
        UserEntity entity = userRepository.findByUsername(username).orElseThrow();
        if (passwordEncoder.matches(oldPassword, userPrincipal.getPassword())){
            String encodedNewPassword = passwordEncoder.encode(newPassword);
            entity.setPassword(encodedNewPassword);
            userRepository.save(entity);
            return true;
        } else {
            return false;
        }
    }


}
