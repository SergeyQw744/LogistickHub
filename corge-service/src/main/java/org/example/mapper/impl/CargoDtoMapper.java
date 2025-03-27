package org.example.mapper.impl;

import org.example.dto.CargoDtoCreate;
import org.example.entity.Cargo;
import org.example.mapper.DtoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CargoDtoMapper implements DtoMapper<CargoDtoCreate, Cargo> {

    private final ModelMapper modelMapper;

    @Autowired
    public CargoDtoMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public CargoDtoCreate toDto(Cargo cargo) {
        return modelMapper.map(cargo, CargoDtoCreate.class);
    }

    @Override
    public Cargo toModel(CargoDtoCreate cargoDtoCreate) {
        return modelMapper.map(cargoDtoCreate, Cargo.class);
    }
}
