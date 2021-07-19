package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.dto.EducationDto;
import com.example.demo.model.entity.Education;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.EducationRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edu")
public class EducationController {
    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getEdus() {
        List<Education> educations = educationRepository.findAll();
        return ResponseEntity.ok().body(educations);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertEdu(@RequestBody EducationDto dto) {
    Education education = new Education(dto.getEduCode(), dto.getSchoolName());

    UserEntity userEntity = userRepository.findByUsername(dto.getUsername());
    education.setUser(userEntity);
    educationRepository.save(education);

    return ResponseEntity.ok().body(education);
  }

    @GetMapping("/test")
    public ResponseEntity<?> testMapping(Integer id) {
        Education education = educationRepository.findAllEducation(id);
        return ResponseEntity.ok().body(education);
    }

    @GetMapping("/by/{id}")
        public ResponseEntity<?> findByIdUser(@PathVariable Integer id) {
        List<Object> edu = educationRepository.findByUserId(id);
        return ResponseEntity.ok().body(edu);
    }
}
