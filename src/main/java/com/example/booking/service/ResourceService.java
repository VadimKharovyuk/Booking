package com.example.booking.service;

import com.example.booking.model.Resource;
import com.example.booking.repository.ResourceRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ResourceService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ResourceRepository resourceRepository;


    public List<Resource> findAll(){
       return resourceRepository.findAll();
    }



    public Resource getResourceById(Long id) {
        Resource resource = (Resource) redisTemplate.opsForValue().get("resource_" + id);
        if (resource == null) {
            resource = resourceRepository.findById(id).orElseThrow();
            redisTemplate.opsForValue().set("resource_" + id, resource);
        }
        return resource;
    }

    public void updateResource(Resource resource) {
        resourceRepository.save(resource);
        redisTemplate.opsForValue().set("resource_" + resource.getId(), resource);
    }

    public void addResource(Resource resource) {
        resourceRepository.save(resource);
    }
}
