package com.example.region.controller;

import java.util.List;

import com.example.region.model.dto.ProvinsiDto;
import com.example.region.model.dto.StatusMessageDto;
import com.example.region.model.entity.Provinsi;
import com.example.region.repository.ProvinsiRepository;
import com.example.region.service.ProvinsiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private ProvinsiService provinsiService;

    @Autowired
    private ProvinsiRepository provinsiRepository;

    // @Autowired
    // private KabupatenKotaRepository kabupatenKotaRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getAllProvinsi(){
        // try {
        //     List<Provinsi> provinsi = provinsiRepository.findAll();
        //     return ResponseEntity.ok().body(provinsi);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Couldn't Find Provinsi");
        // }
        return provinsiService.getAllProvinsi();
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertProvinsi(@RequestBody ProvinsiDto dto){
        // Provinsi provinsi = new Provinsi();
        // provinsi.setProvinsiName(dto.getProvinsiName());
        // provinsi.setProvinsiCode(dto.getProvinsiCode());
        // provinsiRepository.save(provinsi);
        // return ResponseEntity.ok().body(provinsi);
        return provinsiService.insertProvinsi(dto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProvinsi(@RequestBody ProvinsiDto dto, @PathVariable Integer id){
        // Provinsi provinsi = provinsiRepository.findById(id).get();
        // provinsi.setProvinsiName(dto.getProvinsiName());
        // provinsi.setProvinsiCode(dto.getProvinsiCode());
        // provinsiRepository.save(provinsi);
        // return ResponseEntity.ok().body(provinsi);
        return provinsiService.updateProvinsi(dto, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProvinsi(@PathVariable Integer id){
        // try {
        //     Provinsi provinsi = provinsiRepository.findById(id).get();
        //     provinsi.setDeleted(true);
        //     provinsiRepository.save(provinsi);
        //     return ResponseEntity.ok().body(provinsi);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Id Not Found!");
        // }
        return provinsiService.deleteProvinsi(id);
    }

    @GetMapping("/active")
    public ResponseEntity<?> getProvinsiActive() {
        // try {
        //     List<Provinsi> provinsi = provinsiRepository.findByIsDeleted(false);
        //     return ResponseEntity.ok().body(provinsi);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Couldn't reach database");
        // }
        return provinsiService.getProvinsiActive();
    }

    @GetMapping("/byFK/{code}")
    public ResponseEntity<?> getByProvinsiFk(@PathVariable String code) {
        // try {
        //     Provinsi provinsi = provinsiRepository.findByProvinsiCode(code);
        //     List<KabupatenKota> kabKot = kabupatenKotaRepository.findByProvinsi(provinsi);
        //     return ResponseEntity.ok().body(kabKot);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Provinsi Code Not Found!");
        // }
        return provinsiService.getProvinsiFk(code);
    }

    @GetMapping("/by/{id}")
    public ResponseEntity<?> getByIdProvinsi(@PathVariable Integer id) {
        // try {
        //     Provinsi provinsi = provinsiRepository.findById(id).get();
        //     return ResponseEntity.ok().body(provinsi);
        // } catch (Exception e) {
        //     return ResponseEntity.badRequest().body("Id Not Found!");
        // }
        return provinsiService.getByIdProvinsi(id);
    }
    

    @PostMapping("/insert/list")
    public ResponseEntity<?> insertProv(@RequestBody List<ProvinsiDto> dtos) {
        StatusMessageDto<List<ProvinsiDto>> res = new StatusMessageDto<>();
            try {
                for (ProvinsiDto provinsiDto : dtos) {
                    convertDtoToEntity(provinsiDto);
                }

                res.setStatus(HttpStatus.CREATED.toString());
                res.setMessage("Provinsi added!");
                res.setData(dtos);
                return ResponseEntity.ok(res);
            } catch (Exception e) {
                res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
                res.setMessage("Error add provinsi : " + e.getMessage());
                return ResponseEntity.internalServerError().body(res);
            }
    }

    public Provinsi convertDtoToEntity(ProvinsiDto dto) {
        Provinsi provinsi = new Provinsi();
        provinsi.setProvinsiName(dto.getProvinsiName());
        provinsi.setProvinsiCode(dto.getProvinsiCode());
        provinsiRepository.save(provinsi);
        return provinsi;
    }
}
