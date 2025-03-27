package org.example.service;

import org.example.entity.Cargo;
import org.example.entity.CargoStatus;

import java.util.List;

public interface FilterCargoService {

    List<Cargo> findByStatus(CargoStatus status, int page);

    Cargo findByRegistrationNumber(String regNumber);

    List<Cargo> findLastCargos(long timeInMinutes);
}
