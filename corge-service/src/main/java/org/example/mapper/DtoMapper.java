package org.example.mapper;

public interface DtoMapper<Dto, Model> {

    Dto toDto(Model model);

    Model toModel(Dto dto);
}
