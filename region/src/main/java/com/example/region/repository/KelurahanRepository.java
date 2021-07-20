package com.example.region.repository;

import java.util.List;

import com.example.region.model.entity.Kelurahan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KelurahanRepository extends JpaRepository<Kelurahan, Integer>{
    Kelurahan findByKelurahanCode(String kelurahanCode);
    List<Kelurahan> findByKelurahanName(String kelurahanName);
}