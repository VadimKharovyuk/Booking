package com.example.booking.service;

import com.example.booking.model.User;
import com.example.booking.pojo.UserRegistrationDto;
import com.example.booking.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
 // Импортируем BCryptPasswordEncoder из Spring Security
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private  final  UserRepository userRepository;

    public void registerUser(UserRegistrationDto registrationDto) {
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        userRepository.save(user);
    }

    public List<User> findAll (){
        return userRepository.findAll();
    }

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
