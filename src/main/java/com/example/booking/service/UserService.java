package com.example.booking.service;

import com.example.booking.model.User;
import com.example.booking.pojo.UserRegistrationDto;
import com.example.booking.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
 // Импортируем BCryptPasswordEncoder из Spring Security
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private  final  UserRepository userRepository;

    public void registerUser(UserRegistrationDto registrationDto) {
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword()); // Убедитесь, что пароль корректно устанавливается
        userRepository.save(user);
    }
}
