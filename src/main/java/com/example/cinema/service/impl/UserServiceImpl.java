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

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;


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
        if (passwordEncoder.matches(oldPassword, userPrincipal.getPassword())) {
            String encodedNewPassword = passwordEncoder.encode(newPassword);
            entity.setPassword(encodedNewPassword);
            userRepository.save(entity);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void deleteUser(Long id) throws UserPrincipalNotFoundException {
        // Kiểm tra xem khách hàng tồn tại trong cơ sở dữ liệu không
        Optional<UserEntity> existingCustomer = userRepository.findById(id);

        if (existingCustomer.isPresent()) {
            // Nếu khách hàng tồn tại, thực hiện thao tác xóa
            userRepository.deleteById(id);
        } else {
            // Xử lý trường hợp không tìm thấy khách hàng
            throw new UserPrincipalNotFoundException("Không tìm thấy khách hàng với ID " + id);
        }
    }

    @Override
    public void updateUser(User user) throws UserPrincipalNotFoundException {

            Optional<UserEntity> existingUser = userRepository.findById(user.getId());

            if (existingUser.isPresent()) {
                // Nếu khách hàng tồn tại, cập nhật thông tin
                UserEntity updatedUser = existingUser.get();
                updatedUser.setName(user.getName());
                updatedUser.setDateOfBirth(user.getDateOfBirth());
                updatedUser.setPhone(user.getPhone());
                updatedUser.setEmail(user.getEmail());
                updatedUser.setPhone(user.getPhone());
                updatedUser.setAddress(user.getAddress());

                // Lưu khách hàng đã cập nhật vào cơ sở dữ liệu
                userRepository.save(updatedUser);
            } else {
                // Xử lý trường hợp không tìm thấy khách hàng
                throw new UserPrincipalNotFoundException("Không tìm thấy khách hàng với ID " + user.getId());
            }

        }
}




