package com.example.region.repository;

import java.util.List;

import com.example.region.model.entity.KabupatenKota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KabupatenKotaRepository extends JpaRepository<KabupatenKota, Integer>{
    KabupatenKota findByKabupatenKotaCode(String kabupatenKotaCode);

    List<KabupatenKota> findByKabupatenName(String kabupatenName);
    // List<Provinsi> findByProvinsiNameAndKabupatenKotaName(String )
}
