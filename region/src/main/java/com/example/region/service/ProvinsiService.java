package com.example.region.service;

import com.example.region.model.dto.ProvinsiDto;

import org.springframework.http.ResponseEntity;

public interface ProvinsiService {
    public ResponseEntity<?> getAllProvinsi();
    public ResponseEntity<?> getByIdProvinsi(Integer id);
    public ResponseEntity<?> getProvinsiActive();
    public ResponseEntity<?> getProvinsiFk(String code);
    public ResponseEntity<?> insertProvinsi(ProvinsiDto dto);
    public ResponseEntity<?> updateProvinsi(ProvinsiDto dto, Integer id);
    public ResponseEntity<?> deleteProvinsi(Integer id);
}
