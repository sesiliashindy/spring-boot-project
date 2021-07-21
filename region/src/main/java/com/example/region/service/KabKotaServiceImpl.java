package com.example.region.service;

import java.util.List;

import com.example.region.model.dto.KabupatenKotaDto;
import com.example.region.model.entity.KabupatenKota;
import com.example.region.model.entity.Kecamatan;
import com.example.region.model.entity.Provinsi;
import com.example.region.repository.KabupatenKotaRepository;
import com.example.region.repository.KecamatanRepository;
import com.example.region.repository.ProvinsiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KabKotaServiceImpl implements KabupatenKotaService {
    @Autowired
    private KabupatenKotaRepository kabupatenKotaRepository;

    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Override
    public ResponseEntity<?> getAllKabKota() {
        try {
            List<KabupatenKota> kabKota = kabupatenKotaRepository.findAll();
            return ResponseEntity.ok().body(kabKota);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Couldn't Find Kabupaten");
        }
    }

    @Override
    public ResponseEntity<?> getByIdKabKota(Integer id) {
        try {
            KabupatenKota kabKota = kabupatenKotaRepository.findById(id).get();
            return ResponseEntity.ok().body(kabKota);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Id Not Found!");
        }
    }

    @Override
    public ResponseEntity<?> getKabKotaActive() {
        try {
            List<KabupatenKota> kabKota = kabupatenKotaRepository.findByIsDeleted(false);
            return ResponseEntity.ok().body(kabKota);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Couldn't reach database");
        }
    }

    @Override
    public ResponseEntity<?> getByKabKotaFk(String code) {
        try {
            KabupatenKota kabKota = kabupatenKotaRepository.findByKabupatenKotaCode(code);
            List<Kecamatan> kecamatan = kecamatanRepository.findByKabupatenKota(kabKota);
            return ResponseEntity.ok().body(kecamatan);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Kabupaten or Kota Code Not Found!");
        }
    }

    @Override
    public ResponseEntity<?> insertKabKota(KabupatenKotaDto dto) {
        KabupatenKota kabKota = new KabupatenKota();
        kabKota.setKabupatenName(dto.getKabupatenKotaName());
        kabKota.setKabupatenKotaCode(dto.getKabupatenKotaCode());

        Provinsi provinsi = provinsiRepository.findByProvinsiCode(dto.getProvinsiCode());
        kabKota.setProvinsi(provinsi);
        kabupatenKotaRepository.save(kabKota);
        
        return ResponseEntity.ok().body(kabKota);
    }

    @Override
    public ResponseEntity<?> updateKabKota(KabupatenKotaDto dto, Integer id) {
        KabupatenKota kabKot = kabupatenKotaRepository.findById(id).get();
        kabKot.setKabupatenName(dto.getKabupatenKotaName());
        kabKot.setKabupatenKotaCode(dto.getKabupatenKotaCode());
        kabupatenKotaRepository.save(kabKot);
        return ResponseEntity.ok().body(kabKot);
    }

    @Override
    public ResponseEntity<?> deleteKabKota(Integer id) {
        try {
            KabupatenKota kabKot = kabupatenKotaRepository.findById(id).get();
            kabKot.setDeleted(true);
            kabupatenKotaRepository.save(kabKot);
            return ResponseEntity.ok().body(kabKot);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Id Not Found!");
        }
    }
    
}
