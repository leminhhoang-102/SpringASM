package com.example.springasm.dto;

import com.example.springasm.entity.District;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistrictDTO {
    private int id;
    private String name;

    public DistrictDTO() {
    }
    public DistrictDTO(District district){
        this.id = district.getId();
        this.name = district.getName();
    }

}
