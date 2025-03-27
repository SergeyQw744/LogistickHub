package org.example.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.example.entity.UnitOfWeight;

public class CargoDtoCreate {
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 3000)
    private String cargoName;

    @NotNull
    @NotEmpty
    @Positive
    private double weight;

    private UnitOfWeight unitOfWeight;

    @Size(min = 9, max = 9)
    private String pathIdentifier;

    public CargoDtoCreate(){}

    public CargoDtoCreate(String cargoName, double weight, UnitOfWeight unitOfWeight, String pathIdentifier) {
        this.cargoName = cargoName;
        this.weight = weight;
        this.unitOfWeight = unitOfWeight;
        this.pathIdentifier = pathIdentifier;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public UnitOfWeight getUnitOfWeight() {
        return unitOfWeight;
    }

    public void setUnitOfWeight(UnitOfWeight unitOfWeight) {
        this.unitOfWeight = unitOfWeight;
    }

    public String getPathIdentifier() {
        return pathIdentifier;
    }

    public void setPathIdentifier(String pathIdentifier) {
        this.pathIdentifier = pathIdentifier;
    }
}
