package com.example.booking.repository;

import com.example.booking.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResourceRepository extends JpaRepository<Resource,Long> {

}
