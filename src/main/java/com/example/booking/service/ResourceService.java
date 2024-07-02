package com.example.booking.service;

import com.example.booking.model.Resource;
import com.example.booking.repository.ResourceRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ResourceService {

    private final ResourceRepository resourceRepository;


    public List<Resource> findAll(){
       return resourceRepository.findAll();
    }


    @Cacheable(value = "getResourceById", key = "#id")
    public Resource getResourceById(Long id) {
          return   resourceRepository.findById(id).orElseThrow();
    }

    public void addResource(Resource resource) {
        resourceRepository.save(resource);
    }
}
