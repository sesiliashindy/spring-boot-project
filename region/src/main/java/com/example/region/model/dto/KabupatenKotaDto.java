package com.example.region.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KabupatenKotaDto {
    private String kabupatenKotaCode;
    private String kabupatenKotaName;  
    private String provinsiCode;
}
