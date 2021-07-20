package com.example.region.repository;

import java.util.List;

import com.example.region.model.entity.Provinsi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinsiRepository extends JpaRepository<Provinsi, Integer> {
    Provinsi findByProvinsiCode(String provinsiCode);
    List<Provinsi> findByProvinsiName(String provinsiName);
}
