package com.example.booking.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegistrationDto {
    private String username;
    private String email;
    private String password;
}
