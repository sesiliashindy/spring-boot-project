package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

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
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/all")
  public ResponseEntity<?> getUsers() {
    List<UserEntity> users = userRepository.findAll();
    return ResponseEntity.ok().body(users);
    // try {
      
    //   return ResponseEntity.ok().body(userService.getUsers());
    // } catch (Exception e) {
     
    // }
  }

  @PostMapping("/insert")
  public ResponseEntity<?> insertUser(@RequestBody UserDto dto){
    // UserEntity userEntity = new UserEntity(dto.getfName(), dto.getlName(), dto.getNik());
    // if (dto.getNik()==userEntity.getNik()) {
      
    // }
    // userEntity.setPassword(dto.getPassword());

    // userRepository.save(userEntity);

    return ResponseEntity.ok().body(userService.insertUser(dto));
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable Integer id){
    // if (userRepository.findById(id).isPresent()) {
    //   UserEntity userEntity = userRepository.findById(id).get();
    //   return ResponseEntity.ok().body(userEntity);      
    // }
    // return ResponseEntity.badRequest().body("id tidak ditemukan");
    return userService.getById(id);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateUser(@RequestBody UserDto dto, @PathVariable Integer id){
    // UserEntity userEntity = userRepository.findById(id).get();
    // userEntity.setFirstName(dto.getfName());
    // userEntity.setLastName(dto.getlName());
    // userRepository.save(userEntity);
    // return ResponseEntity.ok().body(userEntity);
    // UserEntity userEntity = userRepository.findById(id).get();
    // DetailUser detailUser = detailUserRepository.findByUserEntity(userEntity);
    // detailUser.setFirstName(dto.getfName());
    // detailUser.setLastName(dto.getlName());
    // detailUser.setPhoneNumber(dto.getPhoneNumber());
    // detailUserRepository.save(detailUser);
    return userService.updateUser(dto, id);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable Integer id){
    // UserEntity userEntity = userRepository.findById(id).get();
    // userRepository.delete(userEntity);
    // return ResponseEntity.ok().body("user berhasil dihapus!");
    UserEntity userEntity = userRepository.findById(id).get();
    userEntity.setDeleted(true);
    userRepository.save(userEntity);
    return userService.deleteUser(id);
  }
}
