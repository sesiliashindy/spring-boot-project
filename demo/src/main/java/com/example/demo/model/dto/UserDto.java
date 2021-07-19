package com.example.demo.model.dto;

import lombok.Data;

/**
 * UserDto
 */

@Data
public class UserDto {
    private String fName;
    private String lName;
    private String nik;
    private String password;
    private String phoneNumber;
    private String username;

    
    public UserDto() {
    }

    public UserDto(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}