package com.example.demo.repository;

// import java.util.List;

import com.example.demo.model.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
    // @Query(value="select first_name from user_entity where id = ?", nativeQuery=true)

    // public List<String> getFirstName(Integer id);

    // public List<String> findByFirstNameAndLastName(String fName, String lName);

    // public List<UserEntity> findByLastNameIgnoreCase(String lName);
    
}
