package org.example.mapper.impl;

import org.example.dto.CargoDtoRead;
import org.example.entity.Cargo;
import org.example.mapper.DtoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CargoDtoReadMapper implements DtoMapper<CargoDtoRead, Cargo> {

    private final ModelMapper modelMapper;

    @Autowired
    public CargoDtoReadMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CargoDtoRead toDto(Cargo cargo) {
        return null;
    }

    @Override
    public Cargo toModel(CargoDtoRead cargoDtoRead) {
        return null;
    }
}
