package com.example.region.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "kabupaten")
public class KabupatenKota {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKabupatenKota;

    @Id
    @Column(length = 10, nullable = false, unique = true)
    private String kabupatenKotaCode;

    @Column(length = 50, nullable = false)
    private String kabupatenName;

    @Column()
    private boolean isDeleted = false;

    @ManyToMany
    @JoinColumn(name = "kecamatan_code")
    private Kecamatan kecamatan;
}
