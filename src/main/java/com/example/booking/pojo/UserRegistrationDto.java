package com.example.booking.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class UserRegistrationDto  implements Serializable {
    private String username;
    private String email;
    private String password;
}
