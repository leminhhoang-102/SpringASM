package com.example.springasm.repository;

import com.example.springasm.entity.Street;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<Street,Integer> {
    @Query("select s from Street s where s.district.id = :keywords")
    List<Street> searchByDistrict( int keyword);

    List<Street> findAll();

    List<Street> findAllByDistrictId(int districtId);

    List<Street> findAllByDistrictIdAndNameContains(int districtId, String name);
}
