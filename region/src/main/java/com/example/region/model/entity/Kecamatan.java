package com.example.region.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "kecamatan")
public class Kecamatan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKecamatan;

    @Id
    @Column(length = 10, nullable = false, unique = true)
    private String kecamatanCode;

    @Column(length = 50, nullable = false)
    private String kecamatanName;
    
    @Column()
    private boolean isDeleted = false;
}
