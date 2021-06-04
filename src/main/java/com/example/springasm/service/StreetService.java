package com.example.springasm.service;

import com.example.springasm.dto.StreetDTO;
import com.example.springasm.entity.District;
import com.example.springasm.entity.Street;
import com.example.springasm.repository.DistrictRepository;
import com.example.springasm.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class StreetService {
    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private StreetRepository streetRepository;

    public List<StreetDTO> searchList(int districtId) {
      //  District district = districtRepository.findById(districtId).orElse(null);
        List<StreetDTO> streetDTOList = new ArrayList<>();

        List<Street> list = streetRepository.findAllByDistrictId(districtId);
        for (int i = 0; i < list.size(); i++) {
            StreetDTO streetDTO= new StreetDTO();
            streetDTO.setName(list.get(i).getName());
            streetDTO.setDescription(list.get(i).getDescription());
            streetDTO.setStatus(list.get(i).getStatus());
            streetDTO.setEstablished(list.get(i).getEstablished());
            streetDTO.setDistrictId(districtId);
            streetDTOList.add(streetDTO);
        }
        return  streetDTOList;
    }

    public List<StreetDTO> SearchList2(int districtId, String name){
        List<StreetDTO> streetDTOList = new ArrayList<>();

        List<Street> list = streetRepository.findAllByDistrictIdAndNameContains(districtId,name);
        for (int i = 0; i < list.size(); i++) {
            StreetDTO streetDTO= new StreetDTO();
            streetDTO.setName(list.get(i).getName());
            streetDTO.setDescription(list.get(i).getDescription());
            streetDTO.setStatus(list.get(i).getStatus());
            streetDTO.setEstablished(list.get(i).getEstablished());
            streetDTO.setDistrictId(districtId);
            streetDTOList.add(streetDTO);
        }
        return  streetDTOList;
    }

    public List<StreetDTO> listAll(){
        List<StreetDTO> streetDTOList = new ArrayList<>();
        List<Street> list = streetRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            StreetDTO streetDTO = new StreetDTO();
            streetDTO.setName(list.get(i).getName());
            streetDTO.setDescription(list.get(i).getDescription());
            streetDTO.setStatus(list.get(i).getStatus());
            streetDTO.setEstablished(list.get(i).getEstablished());
            streetDTO.setDistrictId(list.get(i).getDistrict().getId());
            streetDTOList.add(streetDTO);
        }
       return streetDTOList;
    }
}
