package org.example.service;

import org.example.entity.Cargo;
import org.example.entity.CargoStatus;

public interface UpdateStatusCargoService {

    Cargo updateStatus(CargoStatus status, Long id);
}
