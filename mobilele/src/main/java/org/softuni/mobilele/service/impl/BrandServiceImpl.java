package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.BrandDTO;
import org.softuni.mobilele.model.dto.ModelDto;
import org.softuni.mobilele.model.entity.ModelEntity;
import org.softuni.mobilele.repository.ModelRepository;
import org.softuni.mobilele.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelRepository modelRepository;

    public BrandServiceImpl(ModelRepository modelRepository){

        this.modelRepository = modelRepository;
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        Map<String, BrandDTO> brands = new HashMap<>();

        for (ModelEntity model : modelRepository.findAll()) {
           if(!brands.containsKey(model.getBrand())){
               brands.put(model.getBrand().getBrand(), new BrandDTO(model.getBrand().getBrand(), new ArrayList<>()));
           }
           brands.get(model.getBrand().getBrand()).models().add(new ModelDto(model.getId(), model.getName()));
        }

        return brands.values().stream().toList();
    }
}
