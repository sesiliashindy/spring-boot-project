package com.example.region.service;

import java.util.List;

import com.example.region.model.dto.KecamatanDto;
import com.example.region.model.entity.KabupatenKota;
import com.example.region.model.entity.Kecamatan;
import com.example.region.model.entity.Kelurahan;
import com.example.region.repository.KabupatenKotaRepository;
import com.example.region.repository.KecamatanRepository;
import com.example.region.repository.KelurahanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KecamatanServiceImpl implements KecamatanService {
    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private KabupatenKotaRepository kabupatenKotaRepository;

    @Autowired
    private KelurahanRepository kelurahanRepository;

    @Override
    public ResponseEntity<?> getAllKecamatan() {
        try {
            List<Kecamatan> kecamatan = kecamatanRepository.findAll();
            return ResponseEntity.ok().body(kecamatan);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Couldn't Find Kecamatan");
        }
    }

    @Override
    public ResponseEntity<?> getByIdKecamatan(Integer id) {
        try {
            Kecamatan kecamatan = kecamatanRepository.findById(id).get();
            return ResponseEntity.ok().body(kecamatan);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Id Not Found!");
        }
    }

    @Override
    public ResponseEntity<?> getKecamatanActive() {
        try {
            List<Kecamatan> kecamatan = kecamatanRepository.findByIsDeleted(false);
            return ResponseEntity.ok().body(kecamatan);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Couldn't reach database");
        }
    }

    @Override
    public ResponseEntity<?> getByKecamatanFk(String code) {
        try {
            Kecamatan kecamatan = kecamatanRepository.findByKecamatanCode(code);
            List<Kelurahan> kelurahan = kelurahanRepository.findByKecamatan(kecamatan);
            return ResponseEntity.ok().body(kelurahan);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Kecamatan Code Not Found!");
        }
    }

    @Override
    public ResponseEntity<?> insertKecamatan(KecamatanDto dto) {
        Kecamatan kecamatan = new Kecamatan();
        kecamatan.setKecamatanName(dto.getKecamatanName());
        kecamatan.setKecamatanCode(dto.getKecamatanCode());

        KabupatenKota kabKot = kabupatenKotaRepository.findByKabupatenKotaCode(dto.getKabupatenKotaCode());
        kecamatan.setKabupatenKota(kabKot);
        kecamatanRepository.save(kecamatan);

        return ResponseEntity.ok().body(kecamatan);
    }

    @Override
    public ResponseEntity<?> updateKecamatan(KecamatanDto dto, Integer id) {
        Kecamatan kecamatan = kecamatanRepository.findById(id).get();
        kecamatan.setKecamatanName(dto.getKecamatanName());
        kecamatan.setKecamatanCode(dto.getKecamatanCode());
        kecamatanRepository.save(kecamatan);
        return ResponseEntity.ok().body(kecamatan); 
    }

    @Override
    public ResponseEntity<?> deleteKecamatan(Integer id) {
        try {
            Kecamatan kecamatan = kecamatanRepository.findById(id).get();
            kecamatan.setDeleted(true);
            kecamatanRepository.save(kecamatan);
            return ResponseEntity.ok().body(kecamatan);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Id Not Found!");
        }
    }
}
