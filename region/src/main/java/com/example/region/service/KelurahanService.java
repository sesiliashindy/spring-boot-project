package com.example.region.service;

import com.example.region.model.dto.KelurahanDto;

import org.springframework.http.ResponseEntity;

public interface KelurahanService {
    public ResponseEntity<?> getAllKelurahan();
    public ResponseEntity<?> getByIdKelurahan(Integer id);
    public ResponseEntity<?> getKelurahanActive();
    public ResponseEntity<?> getByKelurahanFk(String code);
    public ResponseEntity<?> insertKelurahan(KelurahanDto dto);
    public ResponseEntity<?> updateKelurahan(KelurahanDto dto, Integer id);
    public ResponseEntity<?> deleteKelurahan(Integer id);
}
