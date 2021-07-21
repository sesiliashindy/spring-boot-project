package com.example.region.controller;

import com.example.region.model.dto.KecamatanDto;
import com.example.region.service.KecamatanService;

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
    private KecamatanService kecamatanService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllKecamatan(){
        // try {
        //     List<Kecamatan> kecamatan = kecamatanRepository.findAll();
        //     return ResponseEntity.ok().body(kecamatan);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Couldn't Find Kecamatan");
        // }
        return kecamatanService.getAllKecamatan();
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertKecamatan(@RequestBody KecamatanDto dto){
        // Kecamatan kecamatan = new Kecamatan();
        // kecamatan.setKecamatanName(dto.getKecamatanName());
        // kecamatan.setKecamatanCode(dto.getKecamatanCode());

        // KabupatenKota kabKot = kabupatenKotaRepository.findByKabupatenKotaCode(dto.getKabupatenKotaCode());
        // kecamatan.setKabupatenKota(kabKot);
        // kecamatanRepository.save(kecamatan);

        // return ResponseEntity.ok().body(kecamatan);
        return kecamatanService.insertKecamatan(dto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateKecamatan(@RequestBody KecamatanDto dto, @PathVariable Integer id){
        // Kecamatan kecamatan = kecamatanRepository.findById(id).get();
        // kecamatan.setKecamatanName(dto.getKecamatanName());
        // kecamatan.setKecamatanCode(dto.getKecamatanCode());
        // kecamatanRepository.save(kecamatan);
        // return ResponseEntity.ok().body(kecamatan);
        return kecamatanService.updateKecamatan(dto, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteKecamatan(@PathVariable Integer id){
        // try {
        //     Kecamatan kecamatan = kecamatanRepository.findById(id).get();
        //     kecamatan.setDeleted(true);
        //     kecamatanRepository.save(kecamatan);
        //     return ResponseEntity.ok().body(kecamatan);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Id Not Found!");
        // }
        return kecamatanService.deleteKecamatan(id);
    }
    
    @GetMapping("/active")
    public ResponseEntity<?> getKecamatanActive() {
        // try {
        //     List<Kecamatan> kecamatan = kecamatanRepository.findByIsDeleted(false);
        //     return ResponseEntity.ok().body(kecamatan);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Couldn't reach database");
        // }
        return kecamatanService.getKecamatanActive();
    }

    @GetMapping("/byFK/{code}")
    public ResponseEntity<?> getByKecamatanFk(@PathVariable String code) {
        // try {
        //     Kecamatan kecamatan = kecamatanRepository.findByKecamatanCode(code);
        //     List<Kelurahan> kelurahan = kelurahanRepository.findByKecamatan(kecamatan);
        //     return ResponseEntity.ok().body(kelurahan);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Kecamatan Code Not Found!");
        // }
        return kecamatanService.getByKecamatanFk(code);
    }

    @GetMapping("/by/{id}")
    public ResponseEntity<?> getByIdKecamatan(@PathVariable Integer id) {
        // try {
        //     Kecamatan kecamatan = kecamatanRepository.findById(id).get();
        //     return ResponseEntity.ok().body(kecamatan);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Id Not Found!");
        // }
        return kecamatanService.getByIdKecamatan(id);
    }
}
