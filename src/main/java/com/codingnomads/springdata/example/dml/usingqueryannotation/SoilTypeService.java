package com.codingnomads.springdata.example.dml.usingqueryannotation;

import com.codingnomads.springdata.example.dml.usingqueryannotation.models.SoilType;
import com.codingnomads.springdata.example.dml.usingqueryannotation.repositories.SoilTypeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.SortedMap;

@Service
public class SoilTypeService {

    @Autowired
    SoilTypeRepo soilTypeRepo;

    @Transactional
    public void idError() {
        soilTypeRepo.findById(1L);
    }

    @Transactional
    public void saveStuff() {

        SoilType clay = SoilType.builder()
                .dry(true)
                .ph(7.6)
                .name("test")
                .build();
        soilTypeRepo.save(clay);

        SoilType sandy = SoilType.builder()
                .dry(true)
                .ph(8.1)
                .name("demo")
                .build();
        soilTypeRepo.save(sandy);

        SoilType loamy = SoilType.builder()
                .dry(true)
                .ph(6.6)
                .name("dev")
                .build();
        soilTypeRepo.save(loamy);

        SoilType loam = SoilType.builder()
                .dry(true)
                .ph(5.1)
                .name("batch")
                .build();
        soilTypeRepo.save(loam);

        SoilType peat = SoilType.builder()
                .dry(true)
                .ph(9.4)
                .name("release")
                .build();
        soilTypeRepo.save(peat);

        SoilType chalky = SoilType.builder()
                .dry(true)
                .ph(7.2)
                .name("prod")
                .build();
        soilTypeRepo.save(chalky);
    }
@Transactional
public void getStuff() {

    System.out.println("SORTED DRY SOIL TYPES");
    List<SoilType> soilTypes = soilTypeRepo.getAllSoilTypes(Sort.by(Sort.Order.asc("id")));
    for (SoilType s : soilTypes) {
        System.out.println(s.toString());
        }
    }
}

