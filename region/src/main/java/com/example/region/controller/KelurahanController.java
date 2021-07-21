package com.example.region.controller;

import com.example.region.model.dto.KelurahanDto;
import com.example.region.service.KelurahanService;

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
    private KelurahanService kelurahanService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllKelurahan(){
        // try {
        //     List<Kelurahan> kelurahan = kelurahanRepository.findAll();
        //     return ResponseEntity.ok().body(kelurahan);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Couldn't Find Kelurahan");
        // }
        return kelurahanService.getAllKelurahan();
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertKelurahan(@RequestBody KelurahanDto dto){
        // Kelurahan kelurahan = new Kelurahan();
        // kelurahan.setKelurahanName(dto.getKelurahanName());
        // kelurahan.setKelurahanCode(dto.getKelurahanCode());
        
        // Kecamatan kecamatan = kecamatanRepository.findByKecamatanCode(dto.getKecamatanCode());
        // kelurahan.setKecamatan(kecamatan);
        // kelurahanRepository.save(kelurahan);
        // return ResponseEntity.ok().body(kelurahan);
        return kelurahanService.insertKelurahan(dto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateKelurahan(@RequestBody KelurahanDto dto, @PathVariable Integer id){
        // Kelurahan kelurahan = kelurahanRepository.findById(id).get();
        // kelurahan.setKelurahanName(dto.getKelurahanName());
        // kelurahan.setKelurahanCode(dto.getKelurahanCode());
        // kelurahanRepository.save(kelurahan);
        // return ResponseEntity.ok().body(kelurahan);
        return kelurahanService.updateKelurahan(dto, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteKelurahan(@PathVariable Integer id){
        // try {
        //     Kelurahan kelurahan = kelurahanRepository.findById(id).get();
        //     kelurahan.setDeleted(true);
        //     kelurahanRepository.save(kelurahan);
        //     return ResponseEntity.ok().body(kelurahan);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Id Not Found!");
        // }
        return kelurahanService.deleteKelurahan(id);
    }

    @GetMapping("/active")
    public ResponseEntity<?> getKelurahanActive() {
        // try {
        //     List<Kelurahan> kelurahan = kelurahanRepository.findByIsDeleted(false);
        //     return ResponseEntity.ok().body(kelurahan);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Couldn't reach database");
        // }
        return kelurahanService.getKelurahanActive();
    }

    @GetMapping("/byFK/{code}")
    public ResponseEntity<?> getByKelurahanFk(@PathVariable String code) {
        // try {
        //     Kelurahan kelurahan = kelurahanRepository.findByKelurahanCode(code);
        //     return ResponseEntity.ok().body(kelurahan);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Kelurahan Code Not Found!");
        // }
        return kelurahanService.getByKelurahanFk(code);
    }

    @GetMapping("/by/{id}")
    public ResponseEntity<?> getByIdKelurahan(@PathVariable Integer id) {
        // try {
        //     Kelurahan kelurahan = kelurahanRepository.findById(id).get();
        //     return ResponseEntity.ok().body(kelurahan);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Kelurahan Id Not Found!");
        // }
        return kelurahanService.getByIdKelurahan(id);
    }
    
}
