package com.example.region.service;

import java.util.List;

import com.example.region.model.dto.KelurahanDto;
import com.example.region.model.entity.Kecamatan;
import com.example.region.model.entity.Kelurahan;
import com.example.region.repository.KecamatanRepository;
import com.example.region.repository.KelurahanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KelurahanServiceImpl implements KelurahanService  {
    @Autowired
    private KelurahanRepository kelurahanRepository;

    @Autowired
    private KecamatanRepository kecamatanRepository;
    
    @Override
    public ResponseEntity<?> getAllKelurahan() {
        try {
            List<Kelurahan> kelurahan = kelurahanRepository.findAll();
            return ResponseEntity.ok().body(kelurahan);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Couldn't Find Kelurahan");
        }
    }

    @Override
    public ResponseEntity<?> getByIdKelurahan(Integer id) {
        try {
            Kelurahan kelurahan = kelurahanRepository.findById(id).get();
            return ResponseEntity.ok().body(kelurahan);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Kelurahan Id Not Found!");
        }
    }

    @Override
    public ResponseEntity<?> getKelurahanActive() {
        try {
            List<Kelurahan> kelurahan = kelurahanRepository.findByIsDeleted(false);
            return ResponseEntity.ok().body(kelurahan);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Couldn't reach database");
        }
    }

    @Override
    public ResponseEntity<?> getByKelurahanFk(String code) {
        try {
            Kelurahan kelurahan = kelurahanRepository.findByKelurahanCode(code);
            return ResponseEntity.ok().body(kelurahan);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Kelurahan Code Not Found!");
        }
    }

    @Override
    public ResponseEntity<?> insertKelurahan(KelurahanDto dto) {
        Kelurahan kelurahan = new Kelurahan();
        kelurahan.setKelurahanName(dto.getKelurahanName());
        kelurahan.setKelurahanCode(dto.getKelurahanCode());
        
        Kecamatan kecamatan = kecamatanRepository.findByKecamatanCode(dto.getKecamatanCode());
        kelurahan.setKecamatan(kecamatan);
        kelurahanRepository.save(kelurahan);
        return ResponseEntity.ok().body(kelurahan);
    }

    @Override
    public ResponseEntity<?> updateKelurahan(KelurahanDto dto, Integer id) {
        Kelurahan kelurahan = kelurahanRepository.findById(id).get();
        kelurahan.setKelurahanName(dto.getKelurahanName());
        kelurahan.setKelurahanCode(dto.getKelurahanCode());
        kelurahanRepository.save(kelurahan);
        return ResponseEntity.ok().body(kelurahan);
    }

    @Override
    public ResponseEntity<?> deleteKelurahan(Integer id) {
        try {
            Kelurahan kelurahan = kelurahanRepository.findById(id).get();
            kelurahan.setDeleted(true);
            kelurahanRepository.save(kelurahan);
            return ResponseEntity.ok().body(kelurahan);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Id Not Found!");
        }
    }
}
