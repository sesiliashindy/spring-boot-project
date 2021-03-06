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
@Table(name = "provinsi")
public class Provinsi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10, nullable = false, unique = true)
    private String provinsiCode;

    @Column(length = 50, nullable = false)
    private String provinsiName;

    @Column()
    private boolean isDeleted = false;

    public Provinsi(String provinsiCode, String provinsiName){
        this.provinsiCode = provinsiCode;
        this.provinsiName = provinsiName;
    }

    // @JoinColumn(name = "kabupatenKota_code")
    // private KabupatenKota kabupatenKota;

    // @JoinColumn(name = "kecamatan_code")
    // private Kecamatan kecamatan;

    // @JoinColumn(name = "kelurahan_code")
    // private Kelurahan kelurahan;
    

}
