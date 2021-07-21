package com.example.region.repository;

import java.util.List;

import com.example.region.model.entity.KabupatenKota;
import com.example.region.model.entity.Provinsi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KabupatenKotaRepository extends JpaRepository<KabupatenKota, Integer>{
    // @Query(value = "select kabupaten_kota.kabupaten_name from kabupaten_kota join provinsi on kabupaten_kota.id_provinsi = provinsi.id where kabupaten_kota.kabupaten_code = ?", nativeQuery = true)
    // List<Object> findAllKabupatenKota(String name);
    List<KabupatenKota> findByProvinsi(Provinsi provinsi);
    KabupatenKota findByKabupatenKotaCode(String kabupatenKotaCode);
    List<KabupatenKota> findByIsDeleted(boolean status);

    // List<Object> findByKabupatenKotaId(Integer id);
    // List<Object> findByKabupatenKotaId(Integer id);
    // List<Provinsi> findByProvinsiNameAndKabupatenKotaName(String )
}
