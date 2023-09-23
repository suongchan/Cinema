package com.example.cinema.validator;

import com.example.cinema.domain.User;
import com.example.cinema.exception.FieldMissMatchException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserRegisterValidator {

    public void validateRegisterUser(User user)
            throws FieldMissMatchException {

        if (!Objects.equals(user.getPassword(), user.getRePassword())) {
            throw new FieldMissMatchException("Password miss match");
        }
    }
}
