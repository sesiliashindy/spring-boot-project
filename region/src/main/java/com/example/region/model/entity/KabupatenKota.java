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
@Table(name = "kabupaten_kota")
public class KabupatenKota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10, nullable = false, unique = true)
    private String kabupatenKotaCode;

    @Column(length = 50, nullable = false)
    private String kabupatenName;

    @Column()
    private boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "id_provinsi")
    private Provinsi provinsi;

    public KabupatenKota(String kabupatenKotaCode, String kabupatenKotaName){
        this.kabupatenKotaCode = kabupatenKotaCode;
        this.kabupatenName = kabupatenKotaName;
    }
}
