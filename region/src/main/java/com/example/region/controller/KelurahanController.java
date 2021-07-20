package com.example.region.controller;

import java.util.List;

import com.example.region.model.dto.KelurahanDto;
import com.example.region.model.entity.Kecamatan;
import com.example.region.model.entity.Kelurahan;
import com.example.region.repository.KecamatanRepository;
import com.example.region.repository.KelurahanRepository;

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
@RequestMapping("/kel")
public class KelurahanController {
    @Autowired
    private KelurahanRepository kelurahanRepository;

    @Autowired
    private KecamatanRepository kecamatanRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getKel(){
        List<Kelurahan> kelurahan = kelurahanRepository.findAll();
        return ResponseEntity.ok().body(kelurahan);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertKel(@RequestBody KelurahanDto dto){
        Kelurahan kelurahan = new Kelurahan();
        kelurahan.setKelurahanName(dto.getKelurahanName());
        kelurahan.setKelurahanCode(dto.getKelurahanCode());
        
        Kecamatan kecamatan = kecamatanRepository.findByKecamatanCode(dto.getKecamatanCode());
        kelurahan.setKecamatan(kecamatan);
        kelurahanRepository.save(kelurahan);
        return ResponseEntity.ok().body(kelurahan);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateKel(@RequestBody KelurahanDto dto, @PathVariable Integer id){
        Kelurahan kelurahan = kelurahanRepository.findById(id).get();
        kelurahan.setKelurahanName(dto.getKelurahanName());
        kelurahan.setKelurahanCode(dto.getKelurahanCode());
        kelurahanRepository.save(kelurahan);
        return ResponseEntity.ok().body(kelurahan);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteKec(@PathVariable Integer id){
        Kelurahan kelurahan = kelurahanRepository.findById(id).get();
        kelurahan.setDeleted(true);
        kelurahanRepository.save(kelurahan);
        return ResponseEntity.ok().body(kelurahan);
    }
}
