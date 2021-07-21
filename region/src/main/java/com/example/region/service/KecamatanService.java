package com.example.region.service;

import com.example.region.model.dto.KecamatanDto;

import org.springframework.http.ResponseEntity;

public interface KecamatanService {
    public ResponseEntity<?> getAllKecamatan();
    public ResponseEntity<?> getByIdKecamatan(Integer id);
    public ResponseEntity<?> getKecamatanActive();
    public ResponseEntity<?> getByKecamatanFk(String code);
    public ResponseEntity<?> insertKecamatan(KecamatanDto dto);
    public ResponseEntity<?> updateKecamatan(KecamatanDto dto, Integer id);
    public ResponseEntity<?> deleteKecamatan(Integer id);
}
