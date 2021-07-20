package com.example.region.controller;

import java.util.List;

import com.example.region.model.dto.KabupatenKotaDto;
import com.example.region.model.dto.KecamatanDto;
import com.example.region.model.entity.KabupatenKota;
import com.example.region.model.entity.Kecamatan;
import com.example.region.repository.KabupatenKotaRepository;
import com.example.region.repository.KecamatanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kec")
public class KecamatanController {
    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private KabupatenKotaRepository kabupatenKotaRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getKec(){
        List<Kecamatan> kecamatan = kecamatanRepository.findAll();
        return ResponseEntity.ok().body(kecamatan);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertKec(@RequestBody KecamatanDto dto){
        Kecamatan kecamatan = new Kecamatan();
        kecamatan.setKecamatanName(dto.getKecamatanName());
        kecamatan.setKecamatanCode(dto.getKecamatanCode());

        KabupatenKota kabKot = kabupatenKotaRepository.findByKabupatenKotaCode(dto.getKabupatenKotaCode());
        kecamatan.setKabupatenKota(kabKot);
        kecamatanRepository.save(kecamatan);

        return ResponseEntity.ok().body(kecamatan);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateKec(@RequestBody KecamatanDto dto, @PathVariable Integer id){
        Kecamatan kecamatan = kecamatanRepository.findById(id).get();
        kecamatan.setKecamatanName(dto.getKecamatanName());
        kecamatan.setKecamatanCode(dto.getKecamatanCode());
        kecamatanRepository.save(kecamatan);
        return ResponseEntity.ok().body(kecamatan);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteKec(@PathVariable Integer id){
        Kecamatan kecamatan = kecamatanRepository.findById(id).get();
        kecamatan.setDeleted(true);
        kecamatanRepository.save(kecamatan);
        return ResponseEntity.ok().body(kecamatan);
    }
}
