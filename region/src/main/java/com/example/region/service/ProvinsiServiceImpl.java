package com.example.region.service;

import java.util.List;

import com.example.region.model.dto.ProvinsiDto;
import com.example.region.model.entity.KabupatenKota;
import com.example.region.model.entity.Provinsi;
import com.example.region.repository.KabupatenKotaRepository;
import com.example.region.repository.ProvinsiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinsiServiceImpl implements ProvinsiService{
    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Autowired
    private KabupatenKotaRepository kabupatenKotaRepository;

    @Override
    public ResponseEntity<?> getAllProvinsi() {
        try {
            List<Provinsi> provinsi = provinsiRepository.findAll();
            return ResponseEntity.ok().body(provinsi);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Couldn't Find Provinsi");
        }
    }

    @Override
    public ResponseEntity<?> getByIdProvinsi(Integer id) {
        try {
            Provinsi provinsi = provinsiRepository.findById(id).get();
            return ResponseEntity.ok().body(provinsi);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Id Not Found!");
        }
    }

    @Override
    public ResponseEntity<?> getProvinsiActive() {
        try {
            List<Provinsi> provinsi = provinsiRepository.findByIsDeleted(false);
            return ResponseEntity.ok().body(provinsi);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Couldn't reach database");
        }
    }

    @Override
    public ResponseEntity<?> getProvinsiFk(String code) {
        try {
            Provinsi provinsi = provinsiRepository.findByProvinsiCode(code);
            List<KabupatenKota> kabKot = kabupatenKotaRepository.findByProvinsi(provinsi);
            return ResponseEntity.ok().body(kabKot);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Provinsi Code Not Found!");
        }
    }

    @Override
    public ResponseEntity<?> insertProvinsi(ProvinsiDto dto) {
        Provinsi provinsi = new Provinsi();
        provinsi.setProvinsiName(dto.getProvinsiName());
        provinsi.setProvinsiCode(dto.getProvinsiCode());
        provinsiRepository.save(provinsi);
        return ResponseEntity.ok().body(provinsi);
    }

    @Override
    public ResponseEntity<?> updateProvinsi(ProvinsiDto dto, Integer id) {
        Provinsi provinsi = provinsiRepository.findById(id).get();
        provinsi.setProvinsiName(dto.getProvinsiName());
        provinsi.setProvinsiCode(dto.getProvinsiCode());
        provinsiRepository.save(provinsi);
        return ResponseEntity.ok().body(provinsi);
    }

    @Override
    public ResponseEntity<?> deleteProvinsi(Integer id) {
        try {
            Provinsi provinsi = provinsiRepository.findById(id).get();
            provinsi.setDeleted(true);
            provinsiRepository.save(provinsi);
            return ResponseEntity.ok().body(provinsi);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Id Not Found!");
        }
    }
    
}
