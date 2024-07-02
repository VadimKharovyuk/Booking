package com.example.booking.pojo;

import com.example.booking.model.Resource;
import com.example.booking.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
@Setter
@Getter
public class BookingRequest  implements Serializable {
    private Long userId;
    private Long resourceId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;


    private User user;
    private Resource resource;



}
