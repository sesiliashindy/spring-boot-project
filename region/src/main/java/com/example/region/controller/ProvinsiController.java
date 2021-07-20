package com.example.region.controller;

import java.util.List;

import com.example.region.model.dto.ProvinsiDto;
import com.example.region.model.entity.Provinsi;
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
@RequestMapping("/prov")
public class ProvinsiController {
    @Autowired
    private ProvinsiRepository provinsiRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getProv(){
        List<Provinsi> provinsi = provinsiRepository.findAll();
        return ResponseEntity.ok().body(provinsi);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertProv(@RequestBody ProvinsiDto dto){
        Provinsi provinsi = new Provinsi();
        provinsi.setProvinsiName(dto.getProvinsiName());
        provinsi.setProvinsiCode(dto.getProvinsiCode());
        provinsiRepository.save(provinsi);
        return ResponseEntity.ok().body(provinsi);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProv(@RequestBody ProvinsiDto dto, @PathVariable Integer id){
        Provinsi provinsi = provinsiRepository.findById(id).get();
        provinsi.setProvinsiName(dto.getProvinsiName());
        provinsi.setProvinsiCode(dto.getProvinsiCode());
        provinsiRepository.save(provinsi);
        return ResponseEntity.ok().body(provinsi);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProv(@PathVariable Integer id){
        Provinsi provinsi = provinsiRepository.findById(id).get();
        provinsi.setDeleted(true);
        provinsiRepository.save(provinsi);
        return ResponseEntity.ok().body(provinsi);

    }
}
