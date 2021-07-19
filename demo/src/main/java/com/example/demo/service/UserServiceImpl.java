package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.DetailUser;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.DetailUserRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DetailUserRepository detailUserRepository;
   

    @Override
    public List<UserEntity> getUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users;
    }

    @Override
    public UserEntity insertUser(UserDto dto) {
        // UserEntity userEntity = new UserEntity(dto.getfName(), dto.getlName(), dto.getNik());
        // if (dto.getNik() == userEntity.getNik()) {
        // }
        // userEntity.setPassword(dto.getPassword());
    
        // userRepository.save(userEntity);

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(dto.getUsername());
        userEntity.setPassword(dto.getPassword());
        // userEntity.setDeleted(false);
        userRepository.save(userEntity);

        DetailUser detailUser = new DetailUser(dto.getfName(), dto.getlName(), dto.getNik());

        detailUser.setPhoneNumber(dto.getPhoneNumber());
        detailUser.setUserEntity(userEntity);
        detailUserRepository.save(detailUser);

        return userEntity;
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        if (userRepository.findById(id).isPresent()) {
            UserEntity userEntity = userRepository.findById(id).get();
            return ResponseEntity.ok().body(userEntity); 
        }
        return ResponseEntity.badRequest().body("id tidak ditemukan");
    }

    @Override
    public ResponseEntity<?> updateUser(UserDto dto, Integer id) {
        // UserEntity userEntity = userRepository.findById(id).get();
        // userEntity.setFirstName(dto.getfName());
        // userEntity.setLastName(dto.getlName());
        // userRepository.save(userEntity);
        // return ResponseEntity.ok().body(userEntity);
        UserEntity userEntity = userRepository.findById(id).get();
        DetailUser detailUser = detailUserRepository.findByUserEntity(userEntity);
        detailUser.setFirstName(dto.getfName());
        detailUser.setLastName(dto.getlName());
        detailUser.setPhoneNumber(dto.getPhoneNumber());
        detailUserRepository.save(detailUser);
        return ResponseEntity.ok().body(detailUser);
    }

    @Override
    public ResponseEntity<?> deleteUser(Integer id) {
        // UserEntity userEntity = userRepository.findById(id).get();
        // userRepository.delete(userEntity);
        // return ResponseEntity.ok().body("user berhasil dihapus!");
        return null;
    }
    
}
