package com.example.springasm.dto;

import com.example.springasm.entity.Street;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StreetDTO {
    private int districtId;
    private String name;
    private String description;
    private Date established;
    private int status;

    public StreetDTO(){}
    public StreetDTO(Street street){
        this.name = street.getName();
        this.description= street.getDescription();
        this.established=street.getEstablished();
        this.status = street.getStatus();
        this.districtId=street.getDistrict().getId();
    }
}
