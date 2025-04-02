package org.example.controller;

import org.example.dto.CargoDtoRead;
import org.example.entity.Cargo;
import org.example.entity.CargoStatus;
import org.example.mapper.impl.CargoDtoReadMapper;
import org.example.service.impl.UpdateStatusCargoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cargo/update-status")
public class UpdateStatusCargoController {

    private final UpdateStatusCargoServiceImpl updateStatusCargoService;
    private final CargoDtoReadMapper cargoDtoReadMapper;

    @Autowired
    public UpdateStatusCargoController(UpdateStatusCargoServiceImpl updateStatusCargoService, CargoDtoReadMapper cargoDtoReadMapper) {
        this.updateStatusCargoService = updateStatusCargoService;
        this.cargoDtoReadMapper = cargoDtoReadMapper;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CargoDtoRead> updateState(@RequestParam("status") String status, @PathVariable("id") long id){
        Cargo cargo = updateStatusCargoService.updateStatus(CargoStatus.valueOf(status), id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(cargoDtoReadMapper.toDto(cargo));
    }
}
