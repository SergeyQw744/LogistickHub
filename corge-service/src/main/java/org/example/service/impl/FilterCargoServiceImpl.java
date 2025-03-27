package org.example.service.impl;

import org.example.entity.Cargo;
import org.example.entity.CargoStatus;
import org.example.repository.CargoRepository;
import org.example.service.FilterCargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FilterCargoServiceImpl implements FilterCargoService {

    private final CargoRepository cargoRepository;

    @Autowired
    public FilterCargoServiceImpl(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public List<Cargo> findByStatus(CargoStatus status, int page) {
        return cargoRepository.findByCargoStatusOrderByCargoName(status, PageRequest.of(page, 3))
                .getContent();
    }

    @Override
    public Cargo findByRegistrationNumber(String regNumber) {
        return cargoRepository.findByRegistrationNumber(regNumber)
                .orElseThrow(() -> new RuntimeException("Cargo not found!"));
    }

    @Override
    public List<Cargo> findLastCargos(long timeInMinutes) {
        return cargoRepository.findLastCargos(timeInMinutes);
    }
}
