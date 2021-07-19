package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.UserEntity;

import org.springframework.http.ResponseEntity;

public interface UserService {
    public List<UserEntity> getUsers();  
    public UserEntity insertUser(UserDto dto);
    public ResponseEntity<?> getById(Integer id);
    public ResponseEntity<?> updateUser(UserDto dto, Integer id);
    public ResponseEntity<?> deleteUser(Integer id);
}
