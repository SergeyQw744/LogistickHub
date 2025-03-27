package org.example.service.impl;

import org.example.entity.Cargo;
import org.example.entity.CargoStatus;
import org.example.repository.CargoRepository;
import org.example.service.UpdateStatusCargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateStatusCargoServiceImpl implements UpdateStatusCargoService {

    private final CargoRepository cargoRepository;

    @Autowired
    public UpdateStatusCargoServiceImpl(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    @Transactional
    public Cargo updateStatus(CargoStatus status, Long id) {
        cargoRepository.updateStatus(status, id);
        return cargoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cargo not found"));
    }
}
