package com.example.springasm.controller;


import com.example.springasm.dto.DistrictDTO;
import com.example.springasm.entity.District;
import com.example.springasm.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/district")
public class DistrictController {

    @Autowired
    private DistrictRepository districtRepository;

    @RequestMapping( value = "/list",method = RequestMethod.GET)
    public List<DistrictDTO> listDistrict(){
        List<DistrictDTO> districtDTOList = new LinkedList<>();
        List<District> list = districtRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            DistrictDTO districtDTO = new DistrictDTO(list.get(i));
            districtDTOList.add(districtDTO);
        }
        return districtDTOList;
    }
}
