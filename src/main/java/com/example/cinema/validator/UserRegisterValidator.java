package com.example.cinema.validator;

import com.example.cinema.domain.User;
import com.example.cinema.entity.UserEntity;
import com.example.cinema.exception.FieldMissMatchException;
import com.example.cinema.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserRegisterValidator {

    @Autowired
    private UserRepository userRepository;

    public boolean validateRegisterUser(User user) {

        UserEntity entity = userRepository.findByUsername(user.getUsername()).orElse(null);
        UserEntity email = userRepository.findByEmail(user.getEmail()).orElse(null);
        UserEntity phone = userRepository.findByPhone(user.getPhone()).orElse(null);

        if (Objects.equals(user.getPassword(), user.getRePassword()) && user.getPassword().length() >= 8 && entity == null && email == null && phone == null) {
            return true;
//            throw new FieldMissMatchException("Password miss match");
        }
        return false;
    }
}
