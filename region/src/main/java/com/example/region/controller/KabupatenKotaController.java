package com.example.region.controller;

import java.util.List;

import com.example.region.model.dto.KabupatenKotaDto;
import com.example.region.model.entity.KabupatenKota;
import com.example.region.model.entity.Provinsi;
import com.example.region.repository.KabupatenKotaRepository;
import com.example.region.repository.ProvinsiRepository;

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
@RequestMapping("/kab")
public class KabupatenKotaController {
    @Autowired
    private KabupatenKotaRepository kabupatenKotaRepository;

    // @Autowired
    // private KecamatanRepository kecamatanRepository;
    @Autowired
    private ProvinsiRepository provinsiRepository;
    
    @GetMapping("/all")
    public ResponseEntity<?> getKK(){
        List<KabupatenKota> kabKota = kabupatenKotaRepository.findAll();
        return ResponseEntity.ok().body(kabKota);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertKK(@RequestBody KabupatenKotaDto dto){
        KabupatenKota kabKota = new KabupatenKota();
        kabKota.setKabupatenName(dto.getKabupatenKotaName());
        kabKota.setKabupatenKotaCode(dto.getKabupatenKotaCode());

        // Kecamatan kecamatan = kecamatanRepository.findByKecamatanCode(dto.getKecamatanCode());
        Provinsi provinsi = provinsiRepository.findByProvinsiCode(dto.getProvinsiCode());
        kabKota.setProvinsi(provinsi);
        kabupatenKotaRepository.save(kabKota);
        
        return ResponseEntity.ok().body(kabKota);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateKK(@RequestBody KabupatenKotaDto dto, @PathVariable Integer id){
        KabupatenKota kabKot = kabupatenKotaRepository.findById(id).get();
        kabKot.setKabupatenName(dto.getKabupatenKotaName());
        kabKot.setKabupatenKotaCode(dto.getKabupatenKotaCode());
        kabupatenKotaRepository.save(kabKot);
        return ResponseEntity.ok().body(kabKot);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteKK(@PathVariable Integer id){
        KabupatenKota kabKot = kabupatenKotaRepository.findById(id).get();
        kabKot.setDeleted(true);
        kabupatenKotaRepository.save(kabKot);
        return ResponseEntity.ok().body(kabKot);
    }

}
