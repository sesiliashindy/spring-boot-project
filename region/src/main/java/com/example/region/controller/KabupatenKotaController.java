package com.example.region.controller;

import com.example.region.model.dto.KabupatenKotaDto;
import com.example.region.service.KabupatenKotaService;

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
    private KabupatenKotaService kabupatenKotaService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllKabKota(){
        // try {
        //     List<KabupatenKota> kabKota = kabupatenKotaRepository.findAll();
        //     return ResponseEntity.ok().body(kabKota);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Couldn't Find Kabupaten");
        // }
        return kabupatenKotaService.getAllKabKota();
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertKabKota(@RequestBody KabupatenKotaDto dto){
        // KabupatenKota kabKota = new KabupatenKota();
        // kabKota.setKabupatenName(dto.getKabupatenKotaName());
        // kabKota.setKabupatenKotaCode(dto.getKabupatenKotaCode());

        // Provinsi provinsi = provinsiRepository.findByProvinsiCode(dto.getProvinsiCode());
        // kabKota.setProvinsi(provinsi);
        // kabupatenKotaRepository.save(kabKota);
        
        // return ResponseEntity.ok().body(kabKota);
        return kabupatenKotaService.insertKabKota(dto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateKabKota(@RequestBody KabupatenKotaDto dto, @PathVariable Integer id){
        // KabupatenKota kabKot = kabupatenKotaRepository.findById(id).get();
        // kabKot.setKabupatenName(dto.getKabupatenKotaName());
        // kabKot.setKabupatenKotaCode(dto.getKabupatenKotaCode());
        // kabupatenKotaRepository.save(kabKot);
        // return ResponseEntity.ok().body(kabKot);
        return kabupatenKotaService.updateKabKota(dto, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteKabKota(@PathVariable Integer id){
        // try {
        //     KabupatenKota kabKot = kabupatenKotaRepository.findById(id).get();
        //     kabKot.setDeleted(true);
        //     kabupatenKotaRepository.save(kabKot);
        //     return ResponseEntity.ok().body(kabKot);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Id Not Found!");
        // }
        return kabupatenKotaService.deleteKabKota(id);
    }

    @GetMapping("/active")
    public ResponseEntity<?> getKabKotaActive() {
        // try {
        //     List<KabupatenKota> kabKota = kabupatenKotaRepository.findByIsDeleted(false);
        //     return ResponseEntity.ok().body(kabKota);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Couldn't reach database");
        // }
        return kabupatenKotaService.getKabKotaActive();
    }

    @GetMapping("/byFK/{code}")
    public ResponseEntity<?> getByKabKotaFk(@PathVariable String code) {
        // try {
        //     KabupatenKota kabKota = kabupatenKotaRepository.findByKabupatenKotaCode(code);
        //     List<Kecamatan> kecamatan = kecamatanRepository.findByKabupatenKota(kabKota);
        //     return ResponseEntity.ok().body(kecamatan);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Kabupaten or Kota Code Not Found!");
        // }
        return kabupatenKotaService.getByKabKotaFk(code);
    }

    @GetMapping("/by/{id}")
    public ResponseEntity<?> getByIdKabKota(@PathVariable Integer id) {
        // try {
        //     KabupatenKota kabKota = kabupatenKotaRepository.findById(id).get();
        //     return ResponseEntity.ok().body(kabKota);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Id Not Found!");
        // }
        return kabupatenKotaService.getByIdKabKota(id);
    }
}
