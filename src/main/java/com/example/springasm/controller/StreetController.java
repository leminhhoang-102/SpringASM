package com.example.springasm.controller;

import com.example.springasm.dto.StreetDTO;
import com.example.springasm.entity.District;
import com.example.springasm.entity.Street;
import com.example.springasm.repository.DistrictRepository;
import com.example.springasm.repository.StreetRepository;
import com.example.springasm.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/street")
public class StreetController {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private StreetService streetService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<StreetDTO> getAll(){
        return streetService.listAll();
    }

    @RequestMapping(value = "/list/{districtId}", method = RequestMethod.GET)
    public List<StreetDTO> getStreet(@PathVariable int districtId){
        return streetService.searchList(districtId);
    }

    @RequestMapping(value = "/list2/{districtId}", method = RequestMethod.GET)
    public List<StreetDTO> getStreet2(@PathVariable int districtId,@RequestParam String keyword){

        return streetService.SearchList2(districtId,keyword);
    }

    @RequestMapping(value = "/createStreet/{districtId}",method = RequestMethod.POST)
    public StreetDTO createNewStreet(@PathVariable int districtId, @RequestBody Street street){
        District district = districtRepository.findById(districtId).orElse(null);
        street.setDistrict(district);
        district.addStreet(street);
        districtRepository.save(district);

        StreetDTO streetDTO = new StreetDTO(street);
        return streetDTO;
    }
}
