package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.entity.Education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer>{
    @Query(value = "select education.* from education join user on education.user_id = user.id where user.id = ?", nativeQuery = true)
    Education findAllEducation(Integer id);
  
    List<Object> findByUserId(Integer id);
}
