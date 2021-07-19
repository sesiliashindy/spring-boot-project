package com.example.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEdu;

    @Column(length = 10)
    private String educationCode;

    @Column(length = 50)
    private String schoolName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Education(String educationCode, String schoolName) {
    this.educationCode = educationCode;
    this.schoolName = schoolName;
    }
}
