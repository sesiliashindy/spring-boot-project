package com.example.region.service;

import com.example.region.model.dto.KabupatenKotaDto;
import org.springframework.http.ResponseEntity;

public interface KabupatenKotaService {
    public ResponseEntity<?> getAllKabKota();
    public ResponseEntity<?> getByIdKabKota(Integer id);
    public ResponseEntity<?> getKabKotaActive();
    public ResponseEntity<?> getByKabKotaFk(String code);
    public ResponseEntity<?> insertKabKota(KabupatenKotaDto dto);
    public ResponseEntity<?> updateKabKota(KabupatenKotaDto dto, Integer id);
    public ResponseEntity<?> deleteKabKota(Integer id);
}
