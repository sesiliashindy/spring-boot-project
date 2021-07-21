package com.example.region.repository;

import java.util.List;

import com.example.region.model.entity.Kecamatan;
import com.example.region.model.entity.Kelurahan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KelurahanRepository extends JpaRepository<Kelurahan, Integer>{
    List<Kelurahan> findByKecamatan(Kecamatan kecamatan);
    Kelurahan findByKelurahanCode(String kelurahanCode);
    List<Kelurahan> findByIsDeleted(boolean status);
    // List<Kelurahan> findByKelurahanName(String kelurahanName);
}