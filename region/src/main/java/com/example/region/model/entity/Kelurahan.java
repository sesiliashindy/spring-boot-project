package com.example.region.model.entity;

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
@Table(name = "kelurahan")
public class Kelurahan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10, nullable = false, unique = true)
    private String kelurahanCode;

    @Column(length = 50, nullable = false)
    private String kelurahanName;

    @Column()
    private boolean isDeleted = false;
    
    @ManyToOne
    @JoinColumn(name = "id_kecamatan")
    private Kecamatan kecamatan;

    public Kelurahan(String kelurahanCode, String kelurahanName){
        this.kelurahanCode = kelurahanCode;
        this.kelurahanName = kelurahanName;
    }
}
