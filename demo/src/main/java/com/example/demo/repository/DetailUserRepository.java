package com.example.demo.repository;

import com.example.demo.model.entity.DetailUser;
import com.example.demo.model.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailUserRepository extends JpaRepository<DetailUser, Integer>{
    public DetailUser findByUserEntity(UserEntity userEntity);
}
