package com.example.region.repository;

import java.util.List;

import com.example.region.model.entity.KabupatenKota;
import com.example.region.model.entity.Kecamatan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KecamatanRepository extends JpaRepository<Kecamatan, Integer>{
    List<Kecamatan> findByKabupatenKota(KabupatenKota kabupatenKota);
    Kecamatan findByKecamatanCode(String kecamatanCode);
    List<Kecamatan> findByIsDeleted(boolean status);
}
